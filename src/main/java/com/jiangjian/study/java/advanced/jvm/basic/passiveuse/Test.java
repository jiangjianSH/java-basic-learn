package com.jiangjian.study.java.advanced.jvm.basic.passiveuse;

/**
 * @author jiangjian
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Dog.plate);
    }

    static {
        System.out.println("test init ");
    }
}
