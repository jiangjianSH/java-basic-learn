package com.jiangjian.study.java.designpattern.creational.abstractfactory.macos;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.Button;
import com.jiangjian.study.java.designpattern.creational.abstractfactory.Checkbox;
import com.jiangjian.study.java.designpattern.creational.abstractfactory.GUIFactory;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}