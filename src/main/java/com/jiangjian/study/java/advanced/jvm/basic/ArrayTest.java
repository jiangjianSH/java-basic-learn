package com.jiangjian.study.java.advanced.jvm.basic;

public class ArrayTest {
    public static void main(String[] args) {
        Integer[][] a = new Integer[2][2];
        System.out.println(a.getClass().getName());
        System.out.println(a[0].getClass().getName());
        System.out.println(a[0][0].getClass().getName());
    }
}
