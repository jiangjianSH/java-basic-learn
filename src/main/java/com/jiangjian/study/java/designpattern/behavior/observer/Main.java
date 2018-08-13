package com.jiangjian.study.java.designpattern.behavior.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject(100, 5);
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();
        subject.registerObserver(observerA);
        subject.registerObserver(observerB);
        subject.setSize(20);
    }
}
