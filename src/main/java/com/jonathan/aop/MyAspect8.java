package com.jonathan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Aspect class
@Slf4j
@Aspect
@Component
public class MyAspect8 {

    @Pointcut("execution(* com.jonathan.service.DeptService.*(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("MyAspect8 ... before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("MyAspect8 around before ...");

        //1. Get the class name of the target object.
        String className = joinPoint.getTarget().getClass().getName();
        log.info("the class name of the target object:{}", className);

        //2. Get the method name of the target method.
        String methodName = joinPoint.getSignature().getName();
        log.info("the method name of the target method: {}",methodName);

        //3. Get the parameters passed in when the target method is run.
        Object[] args = joinPoint.getArgs();
        log.info("the parameters passed in when the target method is run: {}", Arrays.toString(args));

        //4. Release the target method for execution.
        Object result = joinPoint.proceed();

        //5. Get the return value of the target method execution.
        log.info("the return value of the target method execution: {}",result);

        log.info("MyAspect8 around after ...");
        return result;
    }
}
