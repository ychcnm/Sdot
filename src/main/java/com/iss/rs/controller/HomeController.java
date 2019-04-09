package com.iss.rs.controller;

import com.iss.rs.entity.Machine;
import com.iss.rs.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource(name = "MacService")
    private MachineService machineService;

    //映射一个action
    @RequestMapping("/index")
    public String index() throws Exception {
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        List<Machine> m = machineService.getAllMachine();
        return "index";
    }
}
