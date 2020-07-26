package com.jdbc.controller;

import com.jdbc.bean.User;
import com.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
//    http://localhost:8082/
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "hello, there";
    }

    //    http://localhost:8082/add
    @RequestMapping("/add")
    public String add() {
        User user = new User("亚历山大", "马其顿王国");
        Integer addUser = userService.addUser(user);
        if (addUser > 0) {
            return user.toString() + "添加成功";
        }
        return user.toString() + "添加失败";
    }

    //    http://localhost:8082/get
    @ResponseBody
    @RequestMapping("/get")
    public List<User> get() {
        List<User> users = userService.getAllUser();

        return users;
    }


}