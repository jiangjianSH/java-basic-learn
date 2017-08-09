package com.jiangjian.study.java.advanced.spring.demo;

import org.springframework.stereotype.Service;

@Service
public class MyRunnableService implements Runnable {
    @Override
    public void run() {
        System.out.println("#####My runnable service is running --thread name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#####My runnable service is ending --thread name: " + Thread.currentThread().getName());

    }
}
