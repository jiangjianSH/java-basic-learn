package com.jiangjian.study.java.advanced.algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {23, 12, 4, 242, 92, 19, 11, 45, 234, 11, 24};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] unSortedArray) {
        if (unSortedArray.length < 2) {
            return;
        }
        int mid = unSortedArray.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[unSortedArray.length - mid];
        for(int i = 0; i < leftArr.length; i++) {
            leftArr[i] = unSortedArray[i];
        }
        for(int j = 0; j < rightArr.length; j++) {
            rightArr[j] = unSortedArray[mid + j];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, unSortedArray);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] unSortedArray) {
        int i = 0, j = 0, k = 0;
        while(i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                unSortedArray[k++] = leftArr[i++];
            } else {
                unSortedArray[k++] = rightArr[j++];
            }
        }
        while( i < leftArr.length) {
            unSortedArray[k++] = leftArr[i++];
        }

        while( j < rightArr.length) {
            unSortedArray[k++] = rightArr[j++];
        }
    }
}
