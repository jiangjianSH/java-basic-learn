package com.jiangjian.study.java.advanced.notify;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class ThreadSafety {
    public static void main(String[] args) throws InterruptedException {
        ProcessingThread processingThread = new ProcessingThread();
        Thread t1 = new Thread(processingThread, "t1");
        Thread t2 = new Thread(processingThread, "t2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("value = " + processingThread.getCount());
    }
}

class ProcessingThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for(int i = 1; i < 5; i++) {
            try {
                Thread.sleep(200L);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }
}
