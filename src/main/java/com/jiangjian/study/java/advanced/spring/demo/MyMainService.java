package com.jiangjian.study.java.advanced.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyMainService {
    @Autowired
    private MyRunnableService myRunnableService;

    public void doService() {
        System.out.println("MyMainService running --thread name: " + Thread.currentThread().getName());
        new Thread(myRunnableService).start();
        System.out.println("MyMainService exiting --thread name: " + Thread.currentThread().getName());
    }
}
