package com.jiangjian.study.java.advanced.jvm.basic.passiveuse;

/**
 * @author jiangjian
 */
public class Animal {
    public static String plate = "earth";

    static {
        System.out.println("animal init");
    }
}
