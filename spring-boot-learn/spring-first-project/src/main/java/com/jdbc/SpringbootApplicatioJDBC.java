package com.jdbc;

import com.common.log.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.log", "com.jdbc"})
public class SpringbootApplicatioJDBC {

    private static MyLog log;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicatioJDBC.class, args);
        log.logStart(SpringbootApplicatioJDBC.class);
    }

    @Autowired
    public SpringbootApplicatioJDBC(MyLog log) {
        SpringbootApplicatioJDBC.log = log;
    }

}
