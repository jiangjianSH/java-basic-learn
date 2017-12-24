package com.jiangjian.study.java.advanced.spring.resources;

import com.jiangjian.study.java.advanced.spring.lifecycle.CustomBeanPostProcessor;
import com.jiangjian.study.java.advanced.spring.lifecycle.ExampleInitBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-resource.xml");
        ExampleBean bean = ac.getBean(ExampleBean.class);
        bean.output();
    }
}
