package com.jiangjian.study.java.advanced.jvm.basic.finalize;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            new Entity();
        }
        System.gc();
        Thread.sleep(5000L);
    }
}
