package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    //    http://localhost:8082/thymeleaf
    @RequestMapping("/thymeleaf")
    public String testThymeleaf(Model modelMap){
        modelMap.addAttribute("msg", "Hello , this is thymeleaf, 百里香");
        return "thymeleaf";
    }

}