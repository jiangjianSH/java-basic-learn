package com.jiangjian.study.java.advanced.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Configuration.class);
        MyMainService myMainService = ac.getBean(MyMainService.class);
        myMainService.doService();
    }
}
