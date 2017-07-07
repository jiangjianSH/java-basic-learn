package com.jiangjian.study.java.multithread.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutorUsage {

    public static class MyRunnable implements Runnable {
        private long base = 0;

        public MyRunnable(long base) {
            this.base = base;
        }

        @Override
        public void run() {
            long sum = 0;
            for(int i = 0; i < base; i++)  {
                sum += i;
            }

            System.out.println(sum);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000L + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        System.out.println("Finnished all threads");
    }
}
