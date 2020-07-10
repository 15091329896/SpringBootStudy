package springboot.TestJDBC;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import springboot.TestJDBC.bean.User;
import springboot.TestJDBC.service.UserService;

@SpringBootTest
class JdbcApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("johnson2");
        user.setAddress("colablog.cn");
        userService.addUser(user);
    }

    public void queryUsers() {
        List<User> allUserFirst = userService.getAllUserFirst();
        System.out.println(allUserFirst);
    }
}