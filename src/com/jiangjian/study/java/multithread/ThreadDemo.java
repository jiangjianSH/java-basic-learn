package com.jiangjian.study.java.multithread;

public class ThreadDemo {
    public static void main(String... args) {
        MyThread t = new MyThread();
        t.start();
        for(int i = 0; i < 50; i++) {
            System.out.println("i = " + i + ", i * i = " + (i * i));
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int count = 1, row = 1; row < 20; count++, row++) {
            for(int i = 0; i < count; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
