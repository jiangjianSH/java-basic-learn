package com.jiangjian.study.java.generic.comparable;

public class Tester {
    public static void main(String[] args) {
        Apple a = new Apple("苹果", 10);

        Orange o = new Orange("橘子", 20);

        System.out.println(a.compareTo(o));
    }
}
