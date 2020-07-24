package com.cache.controller;

import com.cache.bean.User;
import com.cache.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


//    http://localhost:8080/user/save
    @RequestMapping("/save")
    public String save() {
        User user1=new User("陈怀海", "男", 56);
        User user2=new User("由麻子", "男", 56);
        User user3=new User("那正红", "男", 60);
        List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userService.saveAll(users);
        return "保存成功";
    }


    //    http://localhost:8080/user/userName?userName=陈怀海
    @RequestMapping("/userName")
    public User getByUserName(String userName) {
        return userService.getUserByUserName(userName);
    }

//    http://localhost:8080/user/userNameAndAge?userName=陈怀海&age=56
    @RequestMapping("/userNameAndAge")
    public List<User> getByUserNameAndAge(String userName, Integer age) {
        return userService.getUserByUserNameAndAge(userName, age);
    }


    //    http://localhost:8080/user/userNameLike?userName=麻子
    @RequestMapping("/userNameLike")
    public List<User> getByUserNameLike(String userName) {
        return userService.getUserByUserNameLike(userName);
    }
}