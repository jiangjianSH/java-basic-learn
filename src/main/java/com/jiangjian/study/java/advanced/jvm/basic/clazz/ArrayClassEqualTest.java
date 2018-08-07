package com.jiangjian.study.java.advanced.jvm.basic.clazz;

public class ArrayClassEqualTest {
    private static String aStr = "A";
    private static String bStr = "A";

    public static void main(String[] args) {
        Integer[] a = new Integer[2];
        Integer[] b = new Integer[3];
        System.out.println(a.getClass() == b.getClass());

        Integer[][] c = new Integer[2][2];
        Class cClazz = c.getClass();
        System.out.println(a.getClass() == cClazz);
        System.out.println(a.getClass() == c[0].getClass());

        System.out.println( aStr == bStr);
        System.out.println( aStr == Demo.c);
    }
}
