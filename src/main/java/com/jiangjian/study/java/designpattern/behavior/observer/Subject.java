package com.jiangjian.study.java.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int totalNum;
    private int size;

    private List<Observer> observers = new ArrayList<>();

    public Subject(int totalNum, int size) {
        this.totalNum = totalNum;
        this.size = size;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(totalNum, size);
        }
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        notifyObservers();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        notifyObservers();
    }


}
