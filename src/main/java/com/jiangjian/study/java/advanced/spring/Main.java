package com.jiangjian.study.java.advanced.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Main.class);
        ServiceComponent serviceComponent = ac.getBean(ServiceComponent.class);
        serviceComponent.sayHi();
    }
}
