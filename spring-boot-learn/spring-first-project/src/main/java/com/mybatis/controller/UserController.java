package com.mybatis.controller;

import com.mybatis.bean.User;
import com.mybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8082/getUser?username=dyk
    @RequestMapping("/getUser")
    public String getUser(String username){
        User user =userMapper.findUserByUsername(username);
        return user!=null ? username+"的密码是："+user.getUser_password():"不存在用户名为"+username+"的用户";
    }

    //http://localhost:8082/updateUser?username=dyk&password=134
    @RequestMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }


    //http://localhost:8082/addUser?username=dyk&password=123
    @RequestMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.addUser(user);
        return "success!";
    }

    //http://localhost:8082/addUser?username=xiaoli2
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    //http://localhost:8082/getUserList
    @RequestMapping("/getUserList")
    public List getUserList(){
        return userMapper.getUserList();
    }
}