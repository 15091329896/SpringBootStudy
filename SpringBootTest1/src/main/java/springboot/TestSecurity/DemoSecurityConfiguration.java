package springboot.TestSecurity;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class DemoSecurityConfiguration extends WebSecurityConfigurerAdapter {
    protected DemoSecurityConfiguration() {
        super(true); // 取消默认提供的安全相关Filters配置
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
    	System.out.println("自定义配置");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("HTTP 配置");
    }
    // 通过Override其他方法实现对web安全的定制
}