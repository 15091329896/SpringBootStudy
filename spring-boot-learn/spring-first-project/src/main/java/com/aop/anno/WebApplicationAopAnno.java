package com.aop.anno;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @ClassName: WebApplication7171
 * @Description: SpringBoot使用AOP
 * @author dyk
 * @date 2020-07-13 10:03:00
 */
@SpringBootApplication
@ComponentScan(basePackages={ "com.common.*", "com.aop.anno.*" })
public class WebApplicationAopAnno {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplicationAopAnno.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplicationAopAnno.class, args);
		logger.info(" WebApplicationAopAnno  启动成功！ ");
	}

}