package com.jiangjian.study.java.advanced.spring.execution;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MyAsyncBean myAsyncBean = ac.getBean(MyAsyncBean.class);
        System.out.println("Main Thread name : " + Thread.currentThread().getName());
        myAsyncBean.sayGoodMorning();
        myAsyncBean.throwExceptionDemo();
    }
}
