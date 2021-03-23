package com.jiangjian.study.java.advanced.algorithm;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] unSortedArray = {12, 2, 43, 4, 92};
        selectSort(unSortedArray);
        System.out.println(Arrays.toString(unSortedArray));
    }

    public static void selectSort(int[] unSortedArray) {
        int currentPos = 0;
        for(int i = currentPos; i < unSortedArray.length; i++) {
            int smallest = unSortedArray[currentPos];
            for(int j = currentPos + 1; j < unSortedArray.length; j++) {
                if (unSortedArray[j] < smallest) {
                    smallest = unSortedArray[j];
                }
            }
            unSortedArray[currentPos] = smallest;
            currentPos++;
        }
    }
}
