package com.jiangjian.study.java.multithread.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo {
    private static final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);
    private static final RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                    .setNameFormat("test-pool-%d-" + THREAD_NUMBER.getAndIncrement()).build();
            ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(3000), namedThreadFactory, HANDLER);
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("当前线程:" + Thread.currentThread().getName() + " 开始");
                    Thread.sleep(20000);
                    System.out.println("当前线程:" + Thread.currentThread().getName() + " 结束");

                    return null;
                }
            });
            executorService.shutdown();
        }
        System.out.println("主线程结束");
        Thread.sleep(1000000);
    }
}
