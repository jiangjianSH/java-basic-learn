package com.jiangjian.study.java.advanced.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = ac.getBean(Car.class);
        System.out.println(car);

        Mountain mountain = ac.getBean(Mountain.class);
        System.out.println(mountain);

        ConstrucotrInjectWithPrimaryArg construcotrInjectWithPrimaryArg = ac.getBean(ConstrucotrInjectWithPrimaryArg.class);
        System.out.println(construcotrInjectWithPrimaryArg);
    }
}
