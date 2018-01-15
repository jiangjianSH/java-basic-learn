package com.jiangjian.study.java.advanced.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    /**
     * 注意:这里autowire ExampleInitBean的目的是演示Spring Container对于BeanPostProcessor所依赖的bean都是提前创建的,
     */
    @Autowired
    private ExampleInitBean exampleInitBean;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("###Process " + bean.getClass().getName());
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
