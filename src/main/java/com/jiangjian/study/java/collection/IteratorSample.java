package com.jiangjian.study.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class IteratorSample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            iterator.remove();
        }
        System.out.println("The size of list is :" + list.size());
    }
}
