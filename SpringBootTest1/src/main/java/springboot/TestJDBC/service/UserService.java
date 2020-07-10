package springboot.TestJDBC.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import springboot.TestJDBC.bean.User;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public Integer addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);",
                user.getUsername(), user.getAddress());
    }
    
    /**
     * 
    * @Title: getAllUserFirst 
    * @Description: 当类属性和数据库字段不对应时才这样使用
    * @return List<User>
    * @author: dyk
    * @date 2020-07-10 18:26:05
     */
    public List<User> getAllUserFirst() {
        return jdbcTemplate.query("select * from user;", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                user.setId(id);
                user.setUsername(username);
                user.setAddress(address);
                return user;
            }
        });
    }

    
    /**
     * 
    * @Title: getAllUserSecond 
    * @Description: 当类属性和数据库字段对应时就这样使用啦，比上面的简洁很多
    * @return List<User>
    * @throws
    * @author: dyk
    * @date 2020-07-10 18:27:58
     */
    public List<User> getAllUserSecond() {
        return jdbcTemplate.query("select * from user;", new BeanPropertyRowMapper<>(User.class));
    }
    
    
    
}