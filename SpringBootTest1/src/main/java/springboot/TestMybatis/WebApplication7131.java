package springboot.TestMybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;


/**
 * 
* @ClassName: WebApplication7132 
* @Description: SpringBoot整合mybatis
* @author dyk 
* @date 2020-07-13 10:03:00
 */
@SpringBootApplication
@MapperScan(basePackages = "springboot.TestMybatis.mapper")
public class WebApplication7131 {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WebApplication7131.class);

	public static void main(String[] args) {

		SpringApplication.run(WebApplication7131.class, args);
		logger.info(" WebApplication7132  启动成功！ ");

	}

}