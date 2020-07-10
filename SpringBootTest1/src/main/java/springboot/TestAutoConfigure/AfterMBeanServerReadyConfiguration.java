package springboot.TestAutoConfigure;

import javax.management.MBeanServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 
* @ClassName: AfterMBeanServerReadyConfiguration 
* @Description: 希望某些 JMX 操作相关的 bean 定义在 MBeanServer 配置完成之后进行 
* @author dyk 
* @date 2020-07-10 09:44:22
*
 */
@Configuration
@AutoConfigureAfter(JmxAutoConfiguration.class)
public class AfterMBeanServerReadyConfiguration {
	
    @Autowired
    MBeanServer mBeanServer;
    //通过 @Bean 添加必要的 bean 定义
}