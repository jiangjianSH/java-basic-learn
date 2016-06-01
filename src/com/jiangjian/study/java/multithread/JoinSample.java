package com.jiangjian.study.java.multithread;

import java.util.Date;

/**
 * Created by Areadministrator on 2016/5/19.
 */
public class JoinSample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Current Date: " + new Date());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();


        //main thread will wait for 4 seconds
        t.join(4000);
        System.out.println("Main thread will exit");
    }

    public static void outputClassLoader() {
        System.out.println(JoinSample.class.getClassLoader());
    }
}
