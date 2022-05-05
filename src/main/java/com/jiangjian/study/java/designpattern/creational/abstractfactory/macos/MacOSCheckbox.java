package com.jiangjian.study.java.designpattern.creational.abstractfactory.macos;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}