package com.jiangjian.study.java.designpattern.behavior.observer;

public class ObserverB implements Observer {
    @Override
    public void update(int totalNum, int size) {
        System.out.println("平均大小:" + (totalNum / size));
    }
}
