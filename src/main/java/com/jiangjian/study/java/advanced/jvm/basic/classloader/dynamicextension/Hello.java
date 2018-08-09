package com.jiangjian.study.java.advanced.jvm.basic.classloader.dynamicextension;

public class Hello  implements Greeter{
    @Override
    public void greet() {
        System.out.println("Hello world");
    }
}
