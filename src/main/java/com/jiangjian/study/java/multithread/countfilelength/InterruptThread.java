package com.jiangjian.study.java.multithread.countfilelength;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true) {
                try {
                    sleep();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                  //  return;
                }
                System.out.println("child is running");
            }
        });

        t1.setDaemon(true);

        t1.start();

        for(int i = 0; i< 5; i++) {
            Thread.sleep(500L);
            System.out.println("Interrupt child");
            t1.interrupt();
        }
    }

    public static void sleep() throws InterruptedException {
            Thread.sleep(1000L);
    }
}
