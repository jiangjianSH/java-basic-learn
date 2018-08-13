package com.jiangjian.study.java.advanced.jvm.basic.daemon;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        currentThread.setDaemon(true);
    }
}
