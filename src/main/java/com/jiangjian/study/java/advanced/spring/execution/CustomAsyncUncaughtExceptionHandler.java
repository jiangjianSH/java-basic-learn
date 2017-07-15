package com.jiangjian.study.java.advanced.spring.execution;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class CustomAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("Exception type: " + ex.getClass().getName());
        System.out.println("Method name : " + method.getName());
        for(Object param : params) {
            System.out.println("param value : " + param);
        }
    }
}
