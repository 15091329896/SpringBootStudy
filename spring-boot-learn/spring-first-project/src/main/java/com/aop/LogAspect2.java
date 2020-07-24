package com.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
 
/**
* @desc: 经纪人切面
* @author: CSH
**/
@Aspect
@Component
public class LogAspect2 {
 
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
	@Pointcut("execution(* com.aop.*.*(..))")
	public void point() {}
 
    /**
    * @description  在连接点执行之前执行的通知
    */
    @Before("point()")
    public void before(){
        System.out.println("前置通知");
    }
 
    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("point()")
    public void after(){
        System.out.println("后置通知");
    }
 
    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("point()")
    public void afterReturning(){
        System.out.println("返回通知");
    }
 
}