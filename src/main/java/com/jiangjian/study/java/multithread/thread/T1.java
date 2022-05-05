package com.jiangjian.study.java.multithread.thread;

public class T1 implements Runnable {
    @Override
    public void run() {
            ThreadLocalHolder.setDBType("mix");
            ThreadLocalHolder.clearDBType();
            System.out.println("线程1开始睡眠");
        try {
            Thread.sleep(50000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程1结束");
    }
}
