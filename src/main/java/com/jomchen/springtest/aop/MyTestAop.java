package com.jomchen.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * create by Jomchen on 6/20/18
 */
@Component
@Aspect
public class MyTestAop {

    @Around("execution(public * com.jomchen.springtest.interfaces.test.impl.*.*(..))")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("面向切面执行 START");
        System.out.println("面向切面执行 START");
        System.out.println("面向切面执行 START");
        Object result = pjp.proceed();
        System.out.println("面向切面执行 END");
        System.out.println("面向切面执行 END");
        System.out.println("面向切面执行 END");
        return result;
    }

}
