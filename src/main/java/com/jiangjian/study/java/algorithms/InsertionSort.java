package com.jiangjian.study.java.algorithms;

/**
 * Created by jiangjian on 16-10-8.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 3, 9, 1};
        for(int i = 1; i < a.length; i++) {
            int currentValue = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > currentValue) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1]  = currentValue;
        }
        for(int value : a) {
            System.out.print(value + ",");
        }
    }
}
