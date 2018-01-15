package com.jiangjian.study.java.advanced.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectConfig {
    @Pointcut("args(java.io.Serializable)")
    public void myService() {}

    @Before("myService()")
    public void beforeAdvice() {
        System.out.println("before point cut is executing");
    }

    @Around("myService()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        joinPoint.proceed();
        System.out.println("ending");
    }

    @Before("execution(* do*(..))")
    public void beforeDosomething(JoinPoint joinPoint) {
        System.out.println("do before apsect intercept method : " + joinPoint.getSignature().getName());
        System.out.println("method arg length : " + joinPoint.getArgs().length);
    }
}
