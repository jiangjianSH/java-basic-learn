package com.jiangjian.study.java.generic.basic;

import java.util.List;

public class Util  {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p2.getValue().equals(p1.getValue());
    }

    public static void printList(List<?> list) {
        for(Object item : list) {
            System.out.println(item + "");
        }
        System.out.println();
    }

    public static void addNumbers(List<? super Integer> list) {
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
    public static void main(String[] args) {

    }
}
