package com.freemarker;

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
public class WebApplicationFreemark {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplicationFreemark.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplicationFreemark.class, args);
		logger.info(" WebApplicationFreemark  启动成功！ ");
	}

}