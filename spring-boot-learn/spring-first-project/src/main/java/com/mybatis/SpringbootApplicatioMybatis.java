package com.mybatis;

import com.common.log.MyLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.log", "com.mybatis.*"})
@MapperScan(basePackages = {"com.mybatis.*"})
public class SpringbootApplicatioMybatis {

    private static MyLog log;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicatioMybatis.class, args);
        log.logStart(SpringbootApplicatioMybatis.class);
    }

    @Autowired
    public SpringbootApplicatioMybatis(MyLog log) {
        SpringbootApplicatioMybatis.log = log;
    }

}
