package com.jiangjian.study.java.multithread;

import java.util.Date;

public class ThreadLocalSample {
    static class MyRunnable implements Runnable {
        private ThreadLocal<String> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            threadLocal.set(new Date().toString() + Math.random());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
