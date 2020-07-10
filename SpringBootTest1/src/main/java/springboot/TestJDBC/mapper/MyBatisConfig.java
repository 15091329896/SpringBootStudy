package springboot.TestJDBC.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "cn.colablog.mybatis.mapper")
public class MyBatisConfig {
}