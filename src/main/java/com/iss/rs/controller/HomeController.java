package com.iss.rs.controller;

import com.iss.rs.domain.*;
import com.iss.rs.entity.Lot;
import com.iss.rs.entity.Oven;
import com.iss.rs.entity.Productinfo;
import com.iss.rs.service.LotService;
import com.iss.rs.service.OvenService;
import com.iss.rs.service.ProductService;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    public static final String SOLVER_CONFIG
            = "solver/lotSchedulingSolverConfig.xml";
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource(name = "ProductService")
    private ProductService productService;

    @Resource(name = "OvenService")
    private OvenService ovenService;

    @Resource(name = "LotService")
    private LotService lotService;

    //映射一个action
    @RequestMapping("/index")
    public String index() throws Exception {
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "index";
    }

    @RequestMapping("/test")
    public String test() throws Exception {
        //输出日志文件
        logger.info("the test jsp pages");
        //返回一个index.jsp这个视图

        List<Day> dayList = new ArrayList<>(7);
        List<TimeGrain> timeGrainList = new ArrayList<>();
        int k = 0;
        long dayId = 0L, timeGrainId = 0L;
        while (k < 7) {
            Day day = new Day();
            day.setId(dayId++);
            day.setDayOfYear(105 + k);
            dayList.add(day);

            for (int j = 0; j < 24; j++) {
                TimeGrain timeGrain = new TimeGrain();
                timeGrain.setId(timeGrainId);
                timeGrain.setGrainIndex((int) timeGrainId++);
                timeGrain.setDay(day);
                timeGrain.setStartingMinuteOfDay(0 + j * 60);
                timeGrainList.add(timeGrain);
            }
            k++;
        }

        List<Productinfo> productinfoList = productService.getAllProduct();
        List<Oven> ovenList = ovenService.getAllOven();
        Long ovenId = 0L;
        for (Oven o : ovenList) {
            o.setId(ovenId++);
        }

        List<Lot> lotList = lotService.getAllLot();

        Long lotId = 0L;
        for (Lot l : lotList) {
            l.setId(lotId++);
        }

        List<LotAssignment> lotAssignment = new ArrayList<>();
        Long LPId = 0L;
        List<LotPackage> lotPackagesList = new ArrayList<>();

        HashMap<String, Double> filter = new HashMap<>();
        HashMap<String, List<Lot>> container = new HashMap<>();

        for (Lot l : lotList) {
            int time = l.getProductinfo().getBakeTime();
            int temp = l.getProductinfo().getTemperature();
            String s = Integer.toString(time) + temp;
            if (filter.get(s) == null) {
                filter.put(s, l.getRequiredCapacity());
                List<Lot> llist = new ArrayList<>();
                llist.add(l);
                container.put(s, llist);
            } else {
                if (filter.get(s) + l.getRequiredCapacity() > 100.0) {
                    LotPackage lp = new LotPackage(container.get(s), LPId++, temp, time, filter.get(s));
                    lp.setId(lp.getLotPackageId());
                    lotPackagesList.add(lp);

                    filter.remove(s);
                    container.remove(s);

                    filter.put(s, l.getRequiredCapacity());
                    List<Lot> llist = new ArrayList<>();
                    llist.add(l);
                    container.put(s, llist);

                } else {
                    double n = filter.get(s) + l.getRequiredCapacity();
                    List<Lot> llist = container.get(s);
                    llist.add(l);
                    filter.put(s, n);
                    container.put(s, llist);
                }
            }
        }

        for (LotPackage l : lotPackagesList) {
            LotAssignment la = new LotAssignment();
            la.setLotPackage(l);
            la.setId(l.getId());
            lotAssignment.add(la);
        }

        LotSchedule unassignment = new LotSchedule();
        unassignment.setDayList(dayList);
        unassignment.setTimeGrainList(timeGrainList);
        unassignment.setOvenList(ovenList);
        unassignment.setLotList(lotPackagesList);
        unassignment.setLotAssignmentList(lotAssignment);

        unassignment.setId(0L);
        LotConstrainConfiguration constraintConfiguration = new LotConstrainConfiguration();
        constraintConfiguration.setId(0L);
        unassignment.setConstraintConfiguration(constraintConfiguration);

        SolverFactory<LotSchedule> solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver<LotSchedule> solver = solverFactory.buildSolver();

        LotSchedule assigned = solver.solve(unassignment);//启动引擎

        System.out.println(assigned);
        return "test";

    }
}
