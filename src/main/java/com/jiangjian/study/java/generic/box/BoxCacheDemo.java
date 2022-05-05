package com.jiangjian.study.java.generic.box;

import java.util.Arrays;
import java.util.List;

public class BoxCacheDemo {
    public static void main(String[] args) {
        List<Integer> bigs = Arrays.asList(100, 200, 300);
        System.out.println(sumInteger(bigs) == sum(bigs));
        System.out.println(sumInteger(bigs) == sumInteger(bigs));

        //A further subtlety is that boxed values may be cached. Caching is required when boxing
        //an int or short value between–128 and 127, a char value between '\u0000' and
        //'\u007f', a byte, or a boolean
        List<Integer> smalls = Arrays.asList(1, 2, 3);
        System.out.println(sumInteger(smalls) == sum(smalls));
        System.out.println(sumInteger(smalls) == sumInteger(smalls));
    }

    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for(Integer n : ints) {
            s += n;
        }
        return s;
    }

    public static int sum(List<Integer> ints) {
        int s = 0;
        for(int n : ints) {
            s += n;
        }
        return s;
    }
}
