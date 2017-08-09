package com.jiangjian.study.java.advanced.spring.aop;

import org.springframework.stereotype.Service;

/**
 * Created by jiangjian on 2017/7/20.
 */
@Service
public class MyServiceImpl implements MyService {
    public void showHi(Object name) {
        System.out.println("hi" + name);
    }

    @Override
    public void doExercise() {
        System.out.println("do exercise");
    }
}
