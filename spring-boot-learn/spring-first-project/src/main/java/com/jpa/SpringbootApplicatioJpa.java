package com.jpa;

import com.common.log.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.log", "com.jpa.*"})
public class SpringbootApplicatioJpa {

    private static MyLog log;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicatioJpa.class, args);
        log.logStart(SpringbootApplicatioJpa.class);
    }

    @Autowired
    public SpringbootApplicatioJpa(MyLog log) {
        SpringbootApplicatioJpa.log = log;
    }

}
