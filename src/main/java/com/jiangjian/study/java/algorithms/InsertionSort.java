package com.jiangjian.study.java.algorithms;



public class InsertionSort {
    public static void main(String[] args) {

        int a = 1;
        int[] b = new int[10];
        b[1] = 2;
        b[8]=9;
        System.out.println(b);
        System.out.println(b[8]);
        System.out.println(b[1]);
        System.out.println(b[0]);
        System.out.println(b[9]);
        System.out.println(9);
//        int[] a = {4, 5, 3, 9, 1};
//        insertSort(a);
//        for(int value : a) {
//            System.out.print(value + ",");
//        }
    }

    public static void insertSort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i -1;
            while(j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }
}
