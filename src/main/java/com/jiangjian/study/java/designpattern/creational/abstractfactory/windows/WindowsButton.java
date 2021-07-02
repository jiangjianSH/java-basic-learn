package com.jiangjian.study.java.designpattern.creational.abstractfactory.windows;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Button;

public class WindowsButton implements Button {
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}