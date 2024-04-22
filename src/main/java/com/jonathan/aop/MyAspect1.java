package com.jonathan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.jonathan.service.impl.DeptServiceImpl.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        log.info("before ...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //Call the original method of the target object to execute
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("pointCut()")
    public void after() {
        log.info("after ...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }
}
