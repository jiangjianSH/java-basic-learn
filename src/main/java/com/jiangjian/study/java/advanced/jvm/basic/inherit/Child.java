package com.jiangjian.study.java.advanced.jvm.basic.inherit;

public class Child extends Parent {
    public Child() {
        System.out.println("child init");
    }

    static {
        System.out.println("child static block");
    }


    public static void main(String[] args) {
        new Child();
    }
}
