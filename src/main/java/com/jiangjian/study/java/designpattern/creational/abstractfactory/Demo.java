package com.jiangjian.study.java.designpattern.creational.abstractfactory;

import com.jiangjian.study.java.designpattern.creational.abstractfactory.macos.MacOSFactory;
import com.jiangjian.study.java.designpattern.creational.abstractfactory.windows.WindowsFactory;

public class Demo {
    public static void main(String[] args) {
        Application app;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            app = new Application(new MacOSFactory());
        } else {
            app = new Application(new WindowsFactory());
        }
        app.paint();
    }
}
