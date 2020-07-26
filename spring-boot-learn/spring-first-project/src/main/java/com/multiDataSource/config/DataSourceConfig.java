package com.multiDataSource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

/**
 * 处理多数据源的DataSourceConfig，
 * 其中@ConfigurationProperties注解对应刚才的数据库，
 * 而且这个重点是一定要有一个主数据源，并且在上面加上@Primary
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "template4")
    @Qualifier("template4")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.template4")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "template5")
    @Qualifier("template5")
    @ConfigurationProperties(prefix="spring.datasource.template5")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}