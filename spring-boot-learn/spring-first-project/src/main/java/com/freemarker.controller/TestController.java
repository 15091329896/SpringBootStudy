package com.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    //    http://localhost:8082/freemarker
    @RequestMapping("/freemarker")
    public String testFreemarker(Model modelMap){

        modelMap.addAttribute("msg", "Hello , this is freemarker");
        return "freemarker";
    }

    //    http://localhost:8082/index
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","hello pillar");
        return "index";
    }

}