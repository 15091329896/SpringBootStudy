package com.json.controller;

import com.json.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    //http://localhost:8080/json
    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public User index(){
        User user = new User("陈怀海", "26", "好汉街");
        return user;
    }

    //http://localhost:8080/naye
    @GetMapping(value = "/naye",produces = MediaType.APPLICATION_JSON_VALUE)
    public User test(){
        User user = new User("那正红", "56", "好汉街");
        return user;
    }

    //http://localhost:8080/xaioqing
    @GetMapping(value = "/xaioqing",produces = MediaType.APPLICATION_JSON_VALUE)
    public User xaioqing(){
        User user = new User("小晴天", "26", "干饭盆");
        return user;
    }

    //http://localhost:8080/youmazi
    @GetMapping(value = "/youmazi",produces = MediaType.APPLICATION_JSON_VALUE)
    public User youmazi(){
        User user = new User("由麻子", "26", "干饭盆");
        return user;
    }


    //http://localhost:8080/xml
    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public User XML(){
        User user = new User("杜先生", "35", "大连街");
        return user;
    }
}
