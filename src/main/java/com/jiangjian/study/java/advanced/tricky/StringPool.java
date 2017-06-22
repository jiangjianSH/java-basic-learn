package com.jiangjian.study.java.advanced.tricky;

public class StringPool {
    public static void main(String[] args) {
        String a = "Alice";
        String b = "Bob";

        String a1 = "Alice";
        String b1 = new String("Bob");

        System.out.println("a == a1 ? " + (a == a1));
        System.out.println("b == b1 ? " + (b == b1));
    }
}
