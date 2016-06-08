package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Census {
    public static void main(String[] args) {
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);

        for(Thread t : threads) {
            System.out.println(t.getName());
        }
    }
}
