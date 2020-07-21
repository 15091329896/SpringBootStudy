package com.start;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
public class MainApplication {
 
    public static void main(String[] args) {
        System.out.println("=============start===============");
        SpringApplication.run(MainApplication.class,args);
        System.out.println("=============end===============");
    }
}