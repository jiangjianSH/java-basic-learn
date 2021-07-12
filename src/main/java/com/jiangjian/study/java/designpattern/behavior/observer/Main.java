package com.jiangjian.study.java.designpattern.behavior.observer;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager(100, 5);
        EventListener eventListenerA = new EventListenerA();
        EventListener eventListenerB = new EventListenerB();
        eventManager.registerObserver(eventListenerA);
        eventManager.registerObserver(eventListenerB);
        eventManager.setSize(20);
    }
}
