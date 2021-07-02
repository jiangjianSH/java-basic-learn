package com.jiangjian.study.java.multithread;

public class ThreadEnumerateTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyOwnJob());
        t.setName("myJob");
        t.start();
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for(Thread thread : threads) {
            System.out.println("thread name: " + thread.getName());
        }

    }
}

class MyOwnJob implements Runnable {

    @Override
    public void run() {
        System.out.println("hahah");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
