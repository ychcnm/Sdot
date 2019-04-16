package com.iss.rs.controller;

import com.iss.rs.entity.LotConstrainConfiguration;
import com.iss.rs.entity.LotSchedule;
import com.iss.rs.service.ProductService;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.InputStream;

@Controller
@RequestMapping("/home")
public class HomeController {
    public static final String SOLVER_CONFIG
            = "solver/lotSchedulingSolverConfig.xml";
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final int[] startingHourOfDayOptions = {
            0 * 60, // 00:00
            1 * 60, // 01:00
            2 * 60, // 02:00
            3 * 60, // 03:00
            4 * 60, // 04:00
            5 * 60, // 05:00
            6 * 60, // 06:00
            7 * 60, // 07:00
            8 * 60, // 08:00
            9 * 60, // 09:00
            10 * 60, // 10:00
            11 * 60, // 11:00
            13 * 60, // 13:00
            14 * 60, // 14:00
            15 * 60, // 15:00
            16 * 60, // 16:00
            17 * 60, // 17:00
            18 * 60, // 18:00
            19 * 60, // 19:00
            20 * 60, // 20:00
            21 * 60, // 21:00
            22 * 60, // 22:00
            23 * 60, // 23:00
    };
    private final int[] durationInGrainsOptions = {
            1, // 12 hours
            2, // 24 hours
    };
    @Resource(name = "ProductService")
    private ProductService productService;

    //映射一个action
    @RequestMapping("/index")
    public String index() throws Exception {
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图

        InputStream ins = this.getClass().getResourceAsStream(SOLVER_CONFIG);
        SolverFactory<LotSchedule> solverFactory = SolverFactory.createFromXmlInputStream(ins);
        Solver<LotSchedule> solver = solverFactory.buildSolver();
        LotSchedule unassignment = new LotSchedule();


        LotSchedule lotSchedule = new LotSchedule();
        lotSchedule.setId(0L);
        LotConstrainConfiguration constraintConfiguration = new LotConstrainConfiguration();
        constraintConfiguration.setId(0L);
        lotSchedule.setConstraintConfiguration(constraintConfiguration);


        LotSchedule assigned = solver.solve(unassignment);//启动引擎
        return "index";
    }
}
