package com.common.handleException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一异常处理
 *      一旦发生错误，就会调用getErrorPath函数中返回的接口地址的字符串
 *      取请求这个接口，这个接口将决定异常发生时做出何种响应
 */


@RestController
public class CommonErrorController implements ErrorController {

    private final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH)
    public String handleError(){
        return "啊哦，服务器出现了错误，后台正在紧急处理";
    }
}