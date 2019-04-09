package com.iss.rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigateController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayIndexPage() {

        //跳转至首页
        return "index";
    }

    @RequestMapping(value = "/lot", method = RequestMethod.GET)
    public String planLotPage() {

        //跳转至首页
        return "lotPlan";
    }
}
