package com.thymeleaf;

import org.slf4j.Logger;
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
public class WebApplicationThymeleaf {
	private static final Logger logger = LoggerFactory.getLogger(WebApplicationThymeleaf.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplicationThymeleaf.class, args);
		logger.info(" WebApplicationThymeleaf  启动成功！ ");
	}

}