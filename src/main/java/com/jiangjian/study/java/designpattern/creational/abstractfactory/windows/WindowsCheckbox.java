package com.jiangjian.study.java.designpattern.creational.abstractfactory.windows;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}