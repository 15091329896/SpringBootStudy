package com.anno.use;

import com.anno.MyAnnotation;
import com.anno.impl.MyAnnotationImpl;

/**
 * 写一个使用注解的类：
 */
public class Test {

    @MyAnnotation(param="test")
    public void test(){
        System.out.printf("test函数被执行");
    }


    @MyAnnotation(param="test2")
    public void test2(){
        System.out.printf("test2函数被执行");
    }


    public void test3(){
        System.out.printf("test3函数被执行");
    }


}