package com.jiangjian.study.java.advanced.notify;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while(taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + "is waiing ,size is " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000L);
            int i = taskQueue.remove(0);
            System.out.println("Consumed: " + i);
            taskQueue.notifyAll();
        }
    }
}
