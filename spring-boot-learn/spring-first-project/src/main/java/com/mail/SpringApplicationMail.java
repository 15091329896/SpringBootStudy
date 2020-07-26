package com.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.path", "com.mail.*"})
public class SpringApplicationMail {
    private static final Logger log = LoggerFactory.getLogger(SpringApplicationMail.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationMail.class, args);
        log.info("启动成功");
    }

}
