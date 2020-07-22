package springboot.TestSecurity;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @ClassName: WebApplication7171
 * @Description: SpringBoot使用AOP
 * @author dyk
 * @date 2020-07-13 10:03:00
 */
@SpringBootApplication
public class WebApplication7171 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication7171.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication7171.class, args);
		logger.info(" WebApplication7171  启动成功！ ");
	}

}