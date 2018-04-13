package com.jiangjian.study.java.multithread.countdownlatch;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitingAllPartsDoneToProcessByShareVarDemo {
    private AtomicInteger a = new AtomicInteger(10);

    public void countdown() {
        synchronized (a) {
            a.decrementAndGet();
            if (a.get() == 0) {
                a.notify();
            }
        }
    }

    public void await() {
        synchronized (a) {
            try {
                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitingAllPartsDoneToProcessByShareVarDemo shareVariable = new WaitingAllPartsDoneToProcessByShareVarDemo();
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(10) * 1000L);
                    System.out.println(Thread.currentThread().getName() + " has done job");
                    shareVariable.countdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        shareVariable.await();
        System.out.println("hahahah");
    }
}
