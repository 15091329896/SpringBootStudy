package springboot.TestMybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ch.qos.logback.classic.Logger;
import springboot.TestJDBC.bean.User;
import springboot.TestMybatis.service.UserServiceImpl;

@SpringBootTest
class MybatisApplicationTests {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(MybatisApplicationTests.class);
	
    @Autowired
    UserServiceImpl userServiceOfMybatis;

    
    @Test
    public void queryUsers() {
        List<User> allUsers = userServiceOfMybatis.getAllUser();
        logger.info(" 查询成功 --》 allUserFirst = " + allUsers.toString());
    }
}