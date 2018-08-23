package com.jiangjian.study.java.advanced.jvm.basic.instantiate;

/**
 * @author jiangjian
 */
public class Child extends Parent{
    public Child() {
        System.out.println("child constructor");
    }

    public Child(String name) {
        System.out.println("child name :" + name);
    }

    public static void main(String[] args) {
        new Child();
    }
}
