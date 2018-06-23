package com.jomchen.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * create by Jomchen on 6/20/18
 */
@Component
@Aspect
public class MyTestAop {

    @Before("execution(* com.jomchen.springtest.interfaces.test..*(..)) && " +
            "target(com.jomchen.springtest.interfaces.test.impl.MyTestServiceImpl) && args(int5, ..)")
    public void execute(String int5) throws Throwable {
        System.out.println("面向切面执行 START");
        System.out.println("面向切面执行 START");
        System.out.println("面向切面执行 START");
        System.out.println(int5);
        System.out.println(int5);
        System.out.println(int5);
        /*System.out.println(String);
        System.out.println(String);
        System.out.println(String);*/
        System.out.println("面向切面执行 END");
        System.out.println("面向切面执行 END");
        System.out.println("面向切面执行 END");
    }

}
