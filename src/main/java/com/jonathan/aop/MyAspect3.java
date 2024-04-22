package com.jonathan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect3 {

    @Before("execution(* com.jonathan.service.impl.DeptServiceImpl.*(..))")
    public void before() {
        log.info("before ...3");
    }

    @After("execution(* com.jonathan.service.impl.DeptServiceImpl.*(..))")
    public void after() {
        log.info("after ...3");
    }
}
