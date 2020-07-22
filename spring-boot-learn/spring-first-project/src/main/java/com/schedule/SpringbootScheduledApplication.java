package com.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * springboot整合定时任务其实就两点，
 * 1.创建一个能被定时任务类，方法上加入@Scheduled注解
 * 2.在启动类application上加入@EnableScheduling注解
 */

@SpringBootApplication
@EnableScheduling
public class SpringbootScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootScheduledApplication.class, args);
    }
}