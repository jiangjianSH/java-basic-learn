package com.jiangjian.study.java.multithread;

public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyHeavyJob());
        t.start();
        t.join(1000L);
        System.out.println("end join");
    }
}

class MyHeavyJob implements Runnable {

    @Override
    public void run() {
        System.out.println("hello");
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end hello");
    }
}
