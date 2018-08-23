package com.jiangjian.study.java.advanced.jvm.basic.passiveuse.demo;


/**
 * @author jiangjian
 */
public class Test {
    Person person = new Person("Test");
    static  {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}
