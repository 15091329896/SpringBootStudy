package springboot.TestDubbo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

/**
 * 
* @ClassName: WebApplication7202 
* @Description: TODO 
* @author dyk 
* @date 2020-07-20 14:12:43
*
 */
@SpringBootApplication
public class WebApplication7202 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication7202.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication7202.class, args);
		logger.info(" WebApplication7171  启动成功！ ");
	}

}