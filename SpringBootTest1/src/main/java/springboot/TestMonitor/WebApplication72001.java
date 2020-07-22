package springboot.TestMonitor;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @ClassName: WebApplication72001
 * @Description: SpringBoot使用AOP
 * @author dyk
 * @date 2020-07-13 10:03:00
 */
@SpringBootApplication
public class WebApplication72001 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication72001.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication72001.class, args);
		logger.info(" WebApplication7171  启动成功！ ");
	}

}