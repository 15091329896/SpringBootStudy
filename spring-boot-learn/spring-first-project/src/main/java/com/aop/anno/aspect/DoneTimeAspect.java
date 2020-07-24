
/*
      被移入到common中去了
 */
//package com.aop.anno.aspect;
//
//import com.aop.anno.DoneTime;
//import com.common.util.UtilDao;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Aspect
//@Component
//public class DoneTimeAspect {
//
////    这个步骤完成了doneTime注解的反射，获取所有doneTime注解出现的位置，并获取其参数，
////    doneTime注解出现的位置就是当前切面的切点
//    @Around("@annotation(doneTime)")
//    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
//        String classname=joinPoint.getTarget().getClass().getSimpleName();
//        String methodname = joinPoint.getSignature().getName();
//        System.out.println(classname + "-->" + methodname + " 方法开始时间是:"+ UtilDao.getCurrentDateTimeString());
//        Object o = joinPoint.proceed();
//        System.out.println(classname + "-->" + methodname + " 方法结束时间是:"+UtilDao.getCurrentDateTimeString()) ;
//        return o;
//    }
//}