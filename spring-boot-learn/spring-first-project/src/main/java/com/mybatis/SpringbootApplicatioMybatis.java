package com.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootApplicatioMybatis {

    private  static final Logger logger = LoggerFactory.getLogger(SpringbootApplicatioMybatis.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicatioMybatis.class, args);
        logger.info("启动成功");
    }

}
