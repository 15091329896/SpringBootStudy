package com.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController2 {


    //    http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        return "hello, there";
    }
}