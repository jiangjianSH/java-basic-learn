package com.jiangjian.study.java.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private int totalNum;
    private int size;

    private List<EventListener> eventListeners = new ArrayList<>();

    public EventManager(int totalNum, int size) {
        this.totalNum = totalNum;
        this.size = size;
    }

    public void registerObserver(EventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void unregisterObserver(EventListener eventListener) {
        eventListeners.remove(eventListener);
    }

    public void notifyObservers() {
        for(EventListener eventListener : eventListeners) {
            eventListener.update(totalNum, size);
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
