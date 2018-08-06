package com.jiangjian.study.java.advanced.jvm.basic.inherit;

public class Parent {
    public Parent() {
        System.out.println("parent init");
    }

    static {
        System.out.println("parent static block");
    }
}
