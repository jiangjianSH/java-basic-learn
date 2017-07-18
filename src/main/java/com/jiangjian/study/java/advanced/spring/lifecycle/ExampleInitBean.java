package com.jiangjian.study.java.advanced.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ExampleInitBean implements InitializingBean, DisposableBean, Lifecycle, BeanNameAware, ApplicationContextAware{

    @Value("${author.name}")
    private String authorName;

    private ApplicationContext ac;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing by InitializingBean Interface, author name:" + authorName);
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing by @PostConstruct, author name:" + authorName);
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy by DisposableBean Interface");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroy by @PreDestroy");
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public void start() {
        System.out.println("LifeCycle.start");
    }

    @Override
    public void stop() {
        System.out.println("LifeCycle.stop");

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware, bean name:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware invoked");
        ac = applicationContext;
    }
}
