package com.jonathan.aop;

import com.alibaba.fastjson.JSONObject;
import com.jonathan.mapper.OperateLogMapper;
import com.jonathan.pojo.OperateLog;
import com.jonathan.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect //Aspect class
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.jonathan.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //operation id: current login id
        //get the jwt in request header, and parse it
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //operation time
        LocalDateTime operateTime = LocalDateTime.now();

        //operation class name
        String className = joinPoint.getTarget().getClass().getName();

        //operation method name
        String methodName = joinPoint.getSignature().getName();

        //operation method parameters
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        long begin = System.currentTimeMillis();

        //call the original target method to execute
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //method return value
        String returnValue = JSONObject.toJSONString(result);

        //operation time-consuming
        Long costTime = end - begin;

        //record the operation log
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP records operation log: {}", operateLog);

        return result;
    }
}
