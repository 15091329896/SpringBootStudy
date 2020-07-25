package com.fileDownloaderAndUpload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //    http://localhost:8082/
    @RequestMapping("/")
    public String index()
    {
        String rootDir = System.getProperty("user.dir");
        System.out.println(rootDir);
        return "IndexThymeleafForDownloaderAndUpload";
    }
}