package com.jiangjian.study.java.designpattern.behavior.observer;

public class ObserverA implements Observer {
    @Override
    public void update(int totalNum, int size) {
        System.out.println("总共:" + totalNum + " 大小为:" + size);
    }
}
