package com.aop.aspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController2
 * @Description
 * @Author dyk
 * @Date 2020/7/24 13:49
 */

@RestController
public class IndexController {


    //    http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        return "hello, there";
    }
}
