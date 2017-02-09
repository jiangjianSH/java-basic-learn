package com.jiangjian.study.java.advanced.notify;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int max_capacity) {
        this.taskQueue = taskQueue;
        MAX_CAPACITY = max_capacity;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while(taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting size:" + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000L);
            taskQueue.add(i);
            System.out.println("produced " + i);
            taskQueue.notifyAll();
        }
    }
}
