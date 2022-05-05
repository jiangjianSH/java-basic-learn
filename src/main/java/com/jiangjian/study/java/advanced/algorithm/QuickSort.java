package com.jiangjian.study.java.advanced.algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] unSortedArray = new int[]{32, 23, 42, 44, 2, 232, 45, 8, 9, 100};
        System.out.println(Arrays.toString(quickSort(unSortedArray)));
    }

    public static int[] quickSort(int[] unSortedArray) {
        if (unSortedArray.length < 2) {
            return unSortedArray;
        }
        int splitBase = unSortedArray[0];
        int[] greaterArray = new int[unSortedArray.length];
        int greaterNum = 0;
        int[] smallerArray = new int[unSortedArray.length];
        int smallerNum = 0;
        for(int i = 1; i < unSortedArray.length; i++) {
            if (splitBase <= unSortedArray[i]) {
                greaterArray[greaterNum++] = unSortedArray[i];
            } else {
                smallerArray[smallerNum++] = unSortedArray[i];
            }
        }
        int[] trimGreaterArray = new int[greaterNum];
        System.arraycopy(greaterArray, 0, trimGreaterArray, 0, greaterNum);
        int[] trimSmallerArray = new int[smallerNum];
        System.arraycopy(smallerArray, 0, trimSmallerArray, 0, smallerNum);
        return mergeArray(quickSort(trimSmallerArray), new int[]{splitBase}, quickSort(trimGreaterArray));
    }

    public static int[] mergeArray(int[] arr1, int[] arr2, int[] arr3) {
        int[] result = new int[arr1.length + arr2.length + arr3.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result,  arr1.length, arr2.length);
        System.arraycopy(arr3, 0, result, arr1.length + arr2.length, arr3.length);
        return result;

    }
}
