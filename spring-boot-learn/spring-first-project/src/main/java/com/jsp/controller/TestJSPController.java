package com.jsp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestJSPController {

    //    http://localhost:8082/jsp
    @RequestMapping("/jsp")
    public String testJSP(Model modelMap){
        modelMap.addAttribute("name", "Hello , this is JSP ");
        return "index";
    }



}