package com.jiangjian.study.java.advanced.jvm.basic.passiveuse.demo;

/**
 * @author jiangjian
 */
public class MyClass extends Test {
    Person person = new Person("MyClass");

    static  {
        System.out.println("my class static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}
