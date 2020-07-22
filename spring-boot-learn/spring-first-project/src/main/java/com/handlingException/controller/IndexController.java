package com.handlingException.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    //    http://localhost:8080/
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //    http://localhost:8080/aaa
    //    http://localhost:8080/test
    @RequestMapping("/test")
    public String test(){
        Map map = null;
        return map.toString();
    }
}