package com.jiangjian.study.java.designpattern.creational.abstractfactory.macos;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}