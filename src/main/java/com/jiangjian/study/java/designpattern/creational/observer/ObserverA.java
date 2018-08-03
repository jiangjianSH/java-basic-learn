package com.jiangjian.study.java.designpattern.creational.observer;

public class ObserverA implements Observer {
    @Override
    public void update(int totalNum, int size) {
        System.out.println("总共:" + totalNum + " 大小为:" + size);
    }
}
