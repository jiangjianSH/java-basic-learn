package com.jiangjian.study.java.multithread.thread;

public class T2 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(50000L);
        System.out.println(ThreadLocalHolder.getDBType());
        ThreadLocalHolder.clearDBType();
        System.out.println("线程1结束");
    }

    @Override
    public void run() {

    }
}
