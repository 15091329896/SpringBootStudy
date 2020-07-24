package com.aop.anno.aspect;

import com.aop.anno.DoneTime;
import com.common.util.UtilDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DoneTimeAspect {

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("方法开始时间是:"+ UtilDao.getCurrentDateTimeString());
        Object o = joinPoint.proceed();
        System.out.println("方法结束时间是:"+UtilDao.getCurrentDateTimeString()) ;
        return o;
    }
}