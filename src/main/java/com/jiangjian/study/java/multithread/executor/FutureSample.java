package com.jiangjian.study.java.multithread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
public class FutureSample {
    public static class MyCallable implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            long sum = 0;
            for(long i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> list = new ArrayList<>();
        for(int i = 0; i < 20000; i++) {
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executorService.submit(worker);
            list.add(submit);
        }
        long sum = 0;
        System.out.println("##size:" + list.size());
        for(Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println("Sum=" + sum);
            executorService.shutdown();
        }
    }
}
