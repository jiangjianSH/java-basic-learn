package com.jiangjian.study.java.advanced.jvm.basic.array;

import java.lang.reflect.Array;

public class ArrayInstance {
    public static void main(String[] args) {
        Array.newInstance(String.class, 5);
        String[][] a = (String[][]) Array.newInstance(String[].class, 5);
        String[] v1 = new String[] {};
        String[] v2 = new String[]{"a", "b"};
        a[0] = v1;
        a[1] = v2;
        System.out.println(a);
    }
}
