package com.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.api.HelloService;

@Service(interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String sayHello(String message) {
        return "hello: " + message;
    }
}
