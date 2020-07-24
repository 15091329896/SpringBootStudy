package com.handlingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.common.handleException"})
public class SpringHandlingExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHandlingExceptionApplication.class, args);
        System.out.printf("启动成功");
    }

}
