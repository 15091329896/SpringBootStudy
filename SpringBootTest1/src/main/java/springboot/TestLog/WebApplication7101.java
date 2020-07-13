package springboot.TestLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
* @ClassName: WebApplication7132
* @Description: SpringBoot的logback框架
* @author dyk 
* @date 2020-07-09 18:18:31
*
 */

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class WebApplication7101 {
 
	private final static Logger logger = LoggerFactory.getLogger(WebApplication7101.class);
	
	public static void main(String[] args) {
		
		logger.info("测试日志系统");
		logger.info("日志测试");
		SpringApplication.run(WebApplication7101.class, args);
		logger.info(" WebApplication7101  启动成功 ");
		
		
		
	}
 
}