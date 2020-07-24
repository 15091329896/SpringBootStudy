package com.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 测试缓存
 *
 */

//开启缓存
@EnableCaching
@SpringBootApplication
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
        System.out.printf(" SpringbootCacheApplication  启动成功");
    }

}
