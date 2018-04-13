package com.jiangjian.study.java.multithread.testsynchronized;

public class SynchonizedTest {
    public synchronized void doHeavyOps() {
        try {
            System.out.println(Thread.currentThread().getName() + ":Go to sleep");
            Thread.sleep(10000L);
            System.out.println(Thread.currentThread().getName() + ":weak up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printMsg() {
        System.out.println(Thread.currentThread().getName() + ":Print Ok");
    }

    public void printMsgWithoutSynchronized() {
        System.out.println(Thread.currentThread().getName() + ":Print Ok (no synchronized)");
    }

    public void printMsgWithBlockSynchonized() {
        System.out.println(Thread.currentThread().getName() + ":Get Block synchronized method");

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ":Print Ok (block synchronized)");
        }
    }

    public static void main(String[] args) {
        SynchonizedTest test = new SynchonizedTest();

        Thread t1 = new Thread(() -> test.doHeavyOps());
        Thread t2 = new Thread(() -> test.printMsg());
        Thread t3 = new Thread(() -> test.printMsgWithoutSynchronized());
        Thread t4 = new Thread(() -> test.printMsgWithBlockSynchonized());
        t1.start();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        t3.start();

        t4.start();
    }
}
