package com.jiangjian.study.java.advanced.jvm.basic.finalize;

public class Entity {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize called");
    }
}
