package com.jiangjian.study.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ExtendKeywordDemo {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(sum(ints));

        List<Double> doubles = Arrays.asList(1.1, 1.2, 1.3);
        System.out.println(sum(doubles));

        List<Number> nums = Arrays.asList(1, 2, 2.7);
        System.out.println(sum(nums));


        count(ints, 2);
        System.out.println(ints);


    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for(Number num : nums) {
            s += num.doubleValue();
        }
        return s;
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for(int i = 0; i < n; i++) {
            ints.add(i);
        }
    }
}
