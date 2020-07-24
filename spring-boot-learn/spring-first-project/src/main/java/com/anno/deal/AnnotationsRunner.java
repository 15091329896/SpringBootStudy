package com.anno.deal;

import com.anno.MyAnnotation;
import com.anno.impl.MyAnnotationImpl;
import com.anno.use.Test;
import java.lang.reflect.Method;
import java.util.Date;

public class AnnotationsRunner {

    private static  MyAnnotationImpl myAnnotation= new MyAnnotationImpl();

    public static void main(String[] args) throws Exception {
        Class clazz = Test.class;
        Method[] ms = clazz.getMethods();
        for (Method method : ms) {
            boolean flag = method.isAnnotationPresent(MyAnnotation.class);
            MyAnnotation myAnnotation=method.getAnnotation(MyAnnotation.class);
            if (flag) {
                String param=myAnnotation.param();
                System.out.println("函数  ： " + param + " 的执行时间如下 " );
                AnnotationsRunner.myAnnotation.myAnnotationsAction();
            }
        }
    }
}