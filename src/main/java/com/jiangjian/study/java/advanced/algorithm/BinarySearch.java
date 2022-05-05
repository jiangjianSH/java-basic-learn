package com.jiangjian.study.java.advanced.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] sortedArr = {1, 3, 4, 9, 23, 43};
        System.out.println(search(sortedArr, 9));
        System.out.println(search(sortedArr, 10));
    }

    public static<T extends Comparable> int search(T sortedArr[], T searchValue) {
        int end = sortedArr.length - 1;
        int start = 0;
        int middle;
        while(start <= end) {
            middle = (start + end) / 2;
            if (sortedArr[middle].compareTo(searchValue) == 0) {
                return middle;
            }
            if (sortedArr[middle].compareTo(searchValue) > 0) {
                end = middle - 1;
            } else {
                start = middle + 1;

            }
        }
        return -1;
    }
}
