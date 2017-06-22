package com.jiangjian.study.java.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/5/19.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            names.add(Integer.toString(i));
        }

        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println("Final size: " + names.size());
    }
}
