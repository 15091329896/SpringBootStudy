package com.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class TestController {

    @Autowired
    private MessageSource messageSource;

    //    http://localhost:8082/
    @RequestMapping("/")
    public String hello(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "IndexThymeleaf";
    }

    //    http://localhost:8082/thymeleaf
    @RequestMapping("/thymeleaf")
    public String testThymeleaf(Model modelMap){
        modelMap.addAttribute("msg", "Hello , this is thymeleaf, 百里香");
        return "thymeleaf";
    }


}