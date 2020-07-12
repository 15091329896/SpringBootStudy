package springboot.TestJDBC;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @ClassName: WebApplication7103
 * @Description: SpringBoot的启动
 * @author dyk
 * @date 2020-07-09 18:18:31
 */

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class WebApplication7103 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication7103.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication7103.class, args);
		logger.info(" WebApplication7103  启动成功！ ");

	}

}