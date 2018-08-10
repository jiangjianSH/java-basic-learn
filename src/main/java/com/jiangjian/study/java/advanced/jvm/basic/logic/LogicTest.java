package com.jiangjian.study.java.advanced.jvm.basic.logic;

public class LogicTest {
    public static void main(String[] args) {
        int a = 0x00000001;
        System.out.println("a  = " + Integer.toBinaryString(a));
        int b = 0xf0000000;
        System.out.println("b = " + Integer.toBinaryString(b));

        int c = a | b;
        System.out.println("a | b = " + Integer.toBinaryString(c));

        int d = a & b;
        System.out.println("a & b = " + Integer.toBinaryString(d));

        int e = ~a;
        System.out.println("~a = " + Integer.toBinaryString(e));

        int f = a << 1;
        System.out.println("a << 1 = " + Integer.toBinaryString(f));

        System.out.println("b =       " + Integer.toBinaryString(b));

        int g = b >> 2;
        System.out.println("b >> 2 =  " + Integer.toBinaryString(g));

        int h = b >>> 3;
        System.out.println("b >>> 3 = " + Integer.toBinaryString(h));
    }
}
