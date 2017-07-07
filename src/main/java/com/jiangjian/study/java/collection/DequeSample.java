package com.jiangjian.study.java.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeSample {
    public static void main(String[] args) {
        System.out.println("Manipulate LinkedList");
        Deque<String> deque1 = new LinkedList<>();
        deque1.add("A");
        deque1.addFirst("B");
        deque1.addLast("C");
        Iterator iterator = deque1.iterator();
        System.out.println("First Item :" + deque1.getFirst());
        System.out.println("Last Item :" + deque1.getLast());
        displayIteratorValue(deque1.iterator());

        System.out.println("\nManipulate ArrayDeque");
        Deque<String> deque2 = new ArrayDeque<>();
        deque2.add("A");
        deque2.addFirst("B");
        deque2.addLast("C");
        System.out.println("First Item :" + deque2.getFirst());
        System.out.println("Last Item :" + deque2.getLast());
        displayIteratorValue(deque2.iterator());
        deque2.add("D");
        System.out.println("\nAfter invoke add:");
        displayIteratorValue(deque2.iterator());

        deque2.removeFirst();
        System.out.println("\nAfter invoke removeFirst:");
        displayIteratorValue(deque2.iterator());

        deque2.remove();
        System.out.println("\nAfter invoke remove:");
        displayIteratorValue(deque2.iterator());

        deque2.removeLast();
        System.out.println("\nAfter invoke removeLast:");
        displayIteratorValue(deque2.iterator());
    }

    private static void displayIteratorValue(Iterator iterator) {
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }

    }
}
