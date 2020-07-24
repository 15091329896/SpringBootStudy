package com.intercept;

import com.common.intercept.CommonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan(basePackages = { "com.common", "com.handlingException.controller" })
public class SpringInterceptApplication extends WebMvcConfigurerAdapter {

    @Autowired
    CommonInterceptor commonInterceptor;


    public static void main(String[] args) {
        SpringApplication.run(SpringInterceptApplication.class, args);
        System.out.printf("启动成功");
    }

    // 增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor);
    }

}
