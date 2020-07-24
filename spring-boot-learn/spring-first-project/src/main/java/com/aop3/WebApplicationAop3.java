package com.aop3;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @ClassName: WebApplication7171
 * @Description: SpringBoot使用AOP
 * @author dyk
 * @date 2020-07-13 10:03:00
 */
@SpringBootApplication
public class WebApplicationAop3 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplicationAop3.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplicationAop3.class, args);
		logger.info(" WebApplicationAop3  启动成功！ ");
	}

}