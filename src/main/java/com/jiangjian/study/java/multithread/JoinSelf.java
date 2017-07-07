package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2016/6/7.
 */
public class JoinSelf {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
        System.out.println("this line can never be reach");
    }
}