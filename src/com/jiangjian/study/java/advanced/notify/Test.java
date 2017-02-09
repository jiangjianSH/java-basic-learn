package com.jiangjian.study.java.advanced.notify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<>();
        Producer producer = new Producer(taskQueue, 5);
        Consumer consumer = new Consumer(taskQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
