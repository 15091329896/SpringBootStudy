package com.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFirstProjectApplication.class, args);
        System.out.printf("启动成功");
    }

}
