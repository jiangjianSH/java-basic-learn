package com.jiangjian.study.java.generic;

import java.util.ArrayList;
import java.util.List;

public class ExtendTest {
    public static void main(String[] args) {
        List<Number> nums = new ArrayList<Number>();
        List<Number> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        nums = ints;
        System.out.println(nums);


        Integer[] ints1 = new Integer[]{1, 2, 3};
        Number[] nums1 = ints1;
        nums1[2] = 3.14;

    }
}
