package com.iss.rs.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iss.rs.domain.*;
import com.iss.rs.entity.Lot;
import com.iss.rs.entity.Oven;
import com.iss.rs.entity.Productinfo;
import com.iss.rs.service.LotService;
import com.iss.rs.service.OvenService;
import com.iss.rs.service.ProductService;
import com.iss.rs.util.ListGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lot")
public class LotController {
    public static final String SOLVER_CONFIG
            = "solver/lotSchedulingSolverConfig.xml";
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LotController.class);
    @Resource(name = "ProductService")
    private ProductService productService;
    @Resource(name = "OvenService")
    private OvenService ovenService;
    @Resource(name = "LotService")
    private LotService lotService;

    //映射一个action
    @RequestMapping("/choosePlan")
    public String choosePlan() throws Exception {
        //输出日志文件
        logger.info("the choose jsp pages");
        //返回一个index.jsp这个视图
        return "choosePlan";
    }

    @RequestMapping(value = "/lotPlan", method = RequestMethod.GET)
    public String planLotPage() {

        //跳转至首页
        return "lotPlan";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadLotPage() {

        //跳转至首页
        return "uploadLot";
    }

    //映射一个action
    @RequestMapping(value = "/getProduct.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, List<String>> getProduct() throws Exception {
        //输出日志文件
        logger.info("/getProduct.do");
        List<Productinfo> product = productService.getAllProduct();
        Map<String, List<String>> resultMap = new HashMap<>();
        product.stream().forEach(p -> {
            String head = p.getProductType().substring(0, 1);
            if (resultMap.containsKey(head)) {
                List<String> list = resultMap.get(head);
                list.add(p.getProductType());
                resultMap.put(head, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(p.getProductType());
                resultMap.put(head, list);
            }
        });
        return resultMap;
    }

    @RequestMapping(value = "/getProductType.do", produces = "application/json")
    @ResponseBody
    public List<String> getProductType(@RequestBody String data) throws Exception {
        //输出日志文件
        logger.info("/getProductType.do");
        Gson gson = new Gson();
        String series = gson.fromJson(data, JsonObject.class).get("series").getAsString();
        System.out.println(series);
        List<String> productType = productService.getProductType(series);
        return productType;
    }

    @RequestMapping("/test")
    public String test() throws Exception {
        //输出日志文件
        logger.info("the test jsp pages");
        //返回一个index.jsp这个视图

        List<Day> dayList = new ArrayList<>(7);
        List<TimeGrain> timeGrainList = new ArrayList<>();

        ListGenerator listGenerator = new ListGenerator();

        listGenerator.generateTimeList(dayList, timeGrainList);

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

        listGenerator.generatePackageList(lotList, lotPackagesList, lotAssignment);


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

        HashMap<Oven, List<LotAssignment>> result = new HashMap<>();

        assigned.getLotAssignmentList().stream().forEach(l -> {
            if (result.containsKey(l.getOven())) {
                List<LotAssignment> lp = result.get(l.getOven());
                lp.add(l);
                result.put(l.getOven(), lp);
            } else {
                List<LotAssignment> lp = new ArrayList<>();
                lp.add(l);
                result.put(l.getOven(), lp);
            }
        });

        return "test";

    }
}
