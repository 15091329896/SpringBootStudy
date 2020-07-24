package com.aop2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController2
 * @Description
 * @Author dyk
 * @Date 2020/7/24 13:49
 */

@RestController
//@RequestMapping("/index2")
public class IndexController {

    //    http://localhost:8080/index
    @RequestMapping("/index")
    public String index() {
        System.out.printf("这是测试2");
        return "hello, there";
    }
}
