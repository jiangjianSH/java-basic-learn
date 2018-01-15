package com.jiangjian.study.java.advanced.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceComponent {
    @Autowired
    private DaoComponent daoComponent;

    public void sayHi() {
        daoComponent.sayHi();
    }
}
