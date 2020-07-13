package springboot.TestAOP;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @ClassName: WebApplication7132
 * @Description: SpringBoot使用AOP
 * @author dyk
 * @date 2020-07-13 10:03:00
 */
@SpringBootApplication
public class WebApplication7132 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication7132.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication7132.class, args);
		logger.info(" WebApplication7132  启动成功！ ");
	}

}