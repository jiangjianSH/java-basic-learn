package com.jiangjian.study.java.generic;

public class ArrayDemo {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3};
        Number[] nums = ints;
        nums[2]=4;
        nums[2]=1.2;
        System.out.println(ints);
    }
}
