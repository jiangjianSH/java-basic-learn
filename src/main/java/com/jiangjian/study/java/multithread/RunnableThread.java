package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("I am child thread");
    }

    public static void main(String[] args) {
        System.out.println("main thread start");
        new Thread(new RunnableThread()).start();
        System.out.println("main thread end");
    }
}
