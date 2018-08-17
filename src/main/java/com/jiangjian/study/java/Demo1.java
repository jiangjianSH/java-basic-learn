package com.jiangjian.study.java;

import java.io.Serializable;

public class Demo1 implements Serializable, Cloneable{
    private int a;
    private String b;
    private boolean c;
    private static final int d = 2;
    private static final String E = "e";

    static {
        System.out.println("static block");
    }
    public Demo1(int a) {
        this.a = a;
    }

    public Demo1(int a, String b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int add(int x, int y) {
        return a + x + y;
    }

    public void sayHi() {
        System.out.println("hi");
    }

    public static int compare(int x, int y) {
        return x -y;
    }
}
