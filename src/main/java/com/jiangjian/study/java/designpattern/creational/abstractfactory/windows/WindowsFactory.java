package com.jiangjian.study.java.designpattern.creational.abstractfactory.windows;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Button;
import com.jiangjian.study.java.designpattern.creational.abstractfactory.Checkbox;
import com.jiangjian.study.java.designpattern.creational.abstractfactory.GUIFactory;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}