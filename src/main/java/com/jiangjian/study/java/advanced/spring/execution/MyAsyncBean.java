package com.jiangjian.study.java.advanced.spring.execution;

import org.springframework.scheduling.annotation.Async;


public class MyAsyncBean {
    @Async
    public void sayGoodMorning() {
        System.out.println("current thread name:" + Thread.currentThread().getName());
        System.out.println("Good Morning.");
    }

    @Async
    public void throwExceptionDemo() {
        System.out.println("current thread name:" + Thread.currentThread().getName());
        throw new RuntimeException("this is demo");
    }
}
