package springboot.TestStartChange;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/**
 * 
* @ClassName: WebApplication7092 
* @Description: 干预SpringBoot的启动
* @author dyk 
* @date 2020-07-09 18:18:31
*
 */

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class WebApplication7092 {
 
	public static void main(String[] args) {
		
//		SpringApplication.run(WebApplication7092.class, args);
		
        SpringApplication bootstrap = new SpringApplication(WebApplication7092.class);
        bootstrap.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
                // 干预SpringBoot的启动
            	
            	System.out.println("干预启动过程");
            }
        });
        
        // 其他定制设置...
//        把 ASCII 字符放到一个资源文件，然后通过 ResourceBanner 来加载：
        bootstrap.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));
        bootstrap.run(args);
		
		
	}
 
}