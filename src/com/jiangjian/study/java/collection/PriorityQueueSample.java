package com.jiangjian.study.java.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSample {
    public static void main(String[] args) {
        Queue<Element> queue = new PriorityQueue(5, new ElementComparator());
        queue.add(new Element(5));
        queue.add(new Element(1));
        queue.add(new Element(2));
        System.out.println(queue.peek().getValue());

        queue.remove();
        System.out.println(queue.peek().getValue());
    }
}
