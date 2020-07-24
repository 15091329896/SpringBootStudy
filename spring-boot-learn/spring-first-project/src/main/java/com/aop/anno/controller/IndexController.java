package com.aop.anno.controller;

import com.common.executeUseTime.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    //    http://localhost:8080/index
    @GetMapping("/index")
    @DoneTime(param = "IndexController")
    public String index(){
        System.out.println("方法执行");
        return "hello world";
    }

    //    http://localhost:8080/index2
    @GetMapping("/index2")
    @DoneTime(param = "IndexController")
    public String index2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法2执行");
        return "hello world";
    }
}