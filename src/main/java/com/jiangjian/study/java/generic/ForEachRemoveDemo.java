package com.jiangjian.study.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachRemoveDemo {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(-1, 2, 10, -3, 2));
//        for(int a : ints) {
//            if (a < 0) {
//                ints.remove(a);
//            }
//        }
        for(Iterator<Integer> it = ints.iterator(); it.hasNext();) {
            if (it.next() < 0) {
                it.remove();
            }
        }
        System.out.println(ints);

    }
}
