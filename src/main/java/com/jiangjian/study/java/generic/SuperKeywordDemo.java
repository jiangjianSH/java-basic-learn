package com.jiangjian.study.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperKeywordDemo {
    public static void main(String[] args) {
        List<Number> objs = new ArrayList<>();
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        copy(objs, ints);
        System.out.println(objs);
    }
    public static <T> void copy(List<T> dst, List<? extends T> src) {

    }

}
