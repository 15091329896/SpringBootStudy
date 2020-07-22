package com.validator.controller;

import com.validator.bean.Book;
import com.validator.bean.Demo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TestDemoController {

    //http://localhost:8080/
    @PostMapping("/")
    public String testDemo(@Valid Demo demo, BindingResult bindingResult){
        return dealErrorMessage(bindingResult);
    }


    //http://localhost:8080/addBook
    @PostMapping("/addBook")
    public String addBook(@Valid Book book, BindingResult bindingResult){
        return dealErrorMessage(bindingResult);
    }


    private String dealErrorMessage(BindingResult bindingResult) {
        StringBuffer stringBuffer=new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> list=bindingResult.getAllErrors();
            for (ObjectError objectError : list) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : "";
    }

}