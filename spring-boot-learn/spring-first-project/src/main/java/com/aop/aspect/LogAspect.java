package com.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description  测试springboot aop
 * @Author dyk
 * @Date 2020/7/24 13:38
 */

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.aop.aspect.*.*(..))")
    public void point(){}

    @Before("point()")
    public void before(){
        System.out.printf("函数调用前 记录");
    }

    @After("point()")
    public void after(){
        System.out.printf("函数调用后 记录");
    }

    @AfterReturning("point()")
    public void afterRetuen(){
        System.out.printf("函数返回后 处理");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("函数调用环绕 处理");
    }


}
