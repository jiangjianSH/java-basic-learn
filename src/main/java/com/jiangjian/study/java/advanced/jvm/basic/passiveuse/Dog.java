package com.jiangjian.study.java.advanced.jvm.basic.passiveuse;

/**
 * @author jiangjian
 */
public class Dog extends Animal {
    static {
        System.out.println("dog init");
    }
}
