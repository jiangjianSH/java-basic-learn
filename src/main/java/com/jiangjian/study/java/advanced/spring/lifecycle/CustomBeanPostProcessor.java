package com.jiangjian.study.java.advanced.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ExampleInitBean) {
            ExampleInitBean exampleInitBean = (ExampleInitBean)bean;
            System.out.println("BeanPostProcess.postProcessBeforeInitialization，author name:"
                    + exampleInitBean.getAuthorName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ExampleInitBean) {
            System.out.println("BeanPostProcessor #postProcessAfterInitialization");
        }
        return bean;
    }
}
