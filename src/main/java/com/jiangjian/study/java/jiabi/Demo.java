package com.jiangjian.study.java.jiabi;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int[] a = new int[5];
        Random random = new Random();
        for(int i = 0; i < 5; i++) {
            a[i] = random.nextInt(100) + 1;
        }
        printArray(a);
    }

    public static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
