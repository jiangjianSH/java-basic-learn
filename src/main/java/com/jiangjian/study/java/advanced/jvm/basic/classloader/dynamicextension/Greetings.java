package com.jiangjian.study.java.advanced.jvm.basic.classloader.dynamicextension;

public class Greetings implements Greeter{
    @Override
    public void greet() {
        System.out.println("Greetings, planet");
    }
}
