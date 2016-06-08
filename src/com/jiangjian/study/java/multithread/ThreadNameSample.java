package com.jiangjian.study.java.multithread;

public class ThreadNameSample {
    public static void main(String[] args) {
        System.out.println("Current thread name :" + Thread.currentThread().getName());
        Thread.currentThread().setName("ThreadNameSample");
        System.out.println("After set, Current thread name :" + Thread.currentThread().getName());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable thread name : " + Thread.currentThread().getName());
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

}
