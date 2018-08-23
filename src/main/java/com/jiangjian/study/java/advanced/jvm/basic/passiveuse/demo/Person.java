package com.jiangjian.study.java.advanced.jvm.basic.passiveuse.demo;

/**
 * @author jiangjian
 */
public class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person :" + str);
    }
}
