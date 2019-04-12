package com.iss.rs.controller;

import com.iss.rs.entity.Productinfo;
import com.iss.rs.service.ProductService;
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

    @Resource(name = "ProductService")
    private ProductService productService;

    //映射一个action
    @RequestMapping("/index")
    public String index() throws Exception {
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        List<Productinfo> p = productService.getAllProduct();
        for(Productinfo i : p){
            System.out.println(i);
        }
        return "index";
    }
}
