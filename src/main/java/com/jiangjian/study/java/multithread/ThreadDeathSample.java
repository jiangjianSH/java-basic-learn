package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
public class ThreadDeathSample {

    public static void main(String... args) {
        try {
            Thread.currentThread().stop();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
