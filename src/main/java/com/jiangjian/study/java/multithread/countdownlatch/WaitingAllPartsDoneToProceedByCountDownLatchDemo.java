package com.jiangjian.study.java.multithread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class WaitingAllPartsDoneToProceedByCountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(3) * 1000L);
                    System.out.println(Thread.currentThread().getName() + " has done job");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        latch.await();

        System.out.println("all children worked done");
    }
}
