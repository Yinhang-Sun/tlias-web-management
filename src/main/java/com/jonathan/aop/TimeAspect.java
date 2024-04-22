package com.jonathan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect //The current class is an aspect class
@Slf4j
public class TimeAspect {

    //@Around("execution(* com.jonathan.service.*.*(..))")
    @Around("com.jonathan.aop.MyAspect1.pointCut()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //Record method execution start time
        long begin = System.currentTimeMillis();

        //execute original method
        Object result = joinPoint.proceed();

        //Record method execution end time
        long end = System.currentTimeMillis();

        //Calculation method execution time
        log.info(joinPoint.getSignature()+"Execution time: {} milliseconds",end-begin);

        return result;
    }
}
