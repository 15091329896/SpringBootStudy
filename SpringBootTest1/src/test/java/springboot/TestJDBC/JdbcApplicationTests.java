package springboot.TestJDBC;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ch.qos.logback.classic.Logger;
import springboot.TestJDBC.bean.User;
import springboot.TestJDBC.service.UserService;

@SpringBootTest
class JdbcApplicationTests {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(JdbcApplicationTests.class);
	
    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("亚里士多德");
        user.setAddress("马其顿王国");
        Integer addUser = userService.addUser(user);
        if (addUser > 0) {
        	logger.info(" 新增成功-->  addUser =  " + addUser);
		} else {
			logger.error(" 新增失败-->  addUser =  " + addUser);
		}
        
    }
    
    @Test
    public void queryUsers() {
        List<User> allUsers = userService.getAllUserFirst();
        logger.info(" 查询成功 --》 allUserFirst = " + allUsers.toString());
    }
}