package com.jiangjian.study.java.multithread.thread;

public class T3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalHolder.setDBType("mix");
        ThreadLocalHolder.clearDBType();
        System.out.println("线程1开始睡眠");
        System.out.println("线程1结束");
    }
}
