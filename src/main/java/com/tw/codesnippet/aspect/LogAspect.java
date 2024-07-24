package com.tw.codesnippet.aspect;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(public int com.tw.codesnippet.utils.Calculator.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Execution method: {}, args: {}",
            joinPoint.getSignature().getName(),
            StrUtil.join(" ", joinPoint.getArgs()));
    }

    @After("pointcut()")
    public void afterAdvice() {
        System.out.println();
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturningAdvice(Object result) {
        log.info("Method executed successfully, return: {}", result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowingAdvice(Exception e) {
        log.info("Method executed exceptionally, exception: {}", e.getMessage());
    }

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
