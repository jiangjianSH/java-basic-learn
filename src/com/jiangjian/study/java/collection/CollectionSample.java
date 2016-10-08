package com.jiangjian.study.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangjian on 16-10-4.
 */
public class CollectionSample {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");

        Set<String> set2 = new HashSet<>();
        set2.add("B");
        set2.add("D");

        set1.addAll(set2);
        System.out.println(set1);

        System.out.println(set1.removeAll(set2));
        System.out.println(set1);

        System.out.println(set1.containsAll(set2));
    }
}
