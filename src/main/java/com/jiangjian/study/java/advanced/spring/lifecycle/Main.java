package com.jiangjian.study.java.advanced.spring.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@ComponentScan
@Configuration
@PropertySource(value = "classpath:spring.properties")
public class Main {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(Main.class);
        ac.start();
        //Following setting applies only to non-web applications. Spring’s web-based ApplicationContext
        // implementations already have code in place to shut down the Spring IoC container
        // gracefully when the relevant web application is shut down
        ac.registerShutdownHook();
    }
}
