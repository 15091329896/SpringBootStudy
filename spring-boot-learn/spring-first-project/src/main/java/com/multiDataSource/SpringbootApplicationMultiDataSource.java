package com.multiDataSource;

import com.common.log.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.log", "com.multiDataSource.*"})
public class SpringbootApplicationMultiDataSource {

    private static MyLog log;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicationMultiDataSource.class, args);
        log.logStart(SpringbootApplicationMultiDataSource.class);
    }

    @Autowired
    public SpringbootApplicationMultiDataSource(MyLog log) {
        SpringbootApplicationMultiDataSource.log = log;
    }

}
