package com.jiangjian.study.java.advanced.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AspectConfig.class);
        MyService myService = ac.getBean(MyService.class);
        myService.showHi("jiangjian");
        myService.showHi(new NoSerialable());

        myService.doExercise();
    }
}
