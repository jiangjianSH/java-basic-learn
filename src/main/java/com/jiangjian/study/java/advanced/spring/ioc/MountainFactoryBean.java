package com.jiangjian.study.java.advanced.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

public class MountainFactoryBean implements FactoryBean<Mountain> {
    @Override
    public Mountain getObject() throws Exception {
        return new Mountain(1000);
    }

    @Override
    public Class<?> getObjectType() {
        return Mountain.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
