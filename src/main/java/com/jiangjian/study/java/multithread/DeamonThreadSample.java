package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class DeamonThreadSample {
    public static void main(String[] args) {
        System.out.println("Current thread is deamon :" + Thread.currentThread().isDaemon());
    }
}
