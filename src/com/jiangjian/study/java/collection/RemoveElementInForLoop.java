package com.jiangjian.study.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class RemoveElementInForLoop {
    public static void main(String[] args) {
        List<String> a  = new ArrayList();
        a.add("A");
        a.add("B");
        for(String item : a) {
            a.remove(item);
            a.remove(item);
        }
        System.out.println("size:" + a.size());
    }
}
