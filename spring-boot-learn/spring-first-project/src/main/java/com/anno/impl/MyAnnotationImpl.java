package com.anno.impl;

import java.util.Date;

/**
 * 一个简单的实现类:
 *
 */
public class MyAnnotationImpl {
    public void myAnnotationsAction() {
        System.out.println("执行自定义注解开始时间："+new Date());
        System.out.println("执行自定义注解");
        System.out.println("执行自定义注解结束时间："+new Date());
    }
}