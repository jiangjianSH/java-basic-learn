package com.jiangjian.study.java.advanced.java8.chap3;

public class UsingLocalVariable {
    public static void main(String[] args) {
        int portNum = 12323;
        Runnable runnable = () -> System.out.println(portNum);
        new Thread(runnable).start();
    }
}
