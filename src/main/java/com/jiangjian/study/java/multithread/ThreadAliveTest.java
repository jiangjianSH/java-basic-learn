package com.jiangjian.study.java.multithread;

public class ThreadAliveTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyJob());
        t.start();
        Thread.sleep(1000L);
        System.out.println(t.isAlive());
        t.start();
    }
}


class MyJob implements Runnable {

    @Override
    public void run() {
        System.out.println("just output hello");
    }
}
