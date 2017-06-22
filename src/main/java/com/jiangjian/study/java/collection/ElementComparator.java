package com.jiangjian.study.java.collection;

import java.util.Comparator;

/**
 * Created by jiangjian on 16-9-24.
 */
public class ElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element o1, Element o2) {
        return o1.getValue() - o2.getValue();
    }
}
