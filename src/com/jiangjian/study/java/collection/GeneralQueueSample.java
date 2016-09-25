package com.jiangjian.study.java.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiangjian on 16-9-24.
 */
public class GeneralQueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Shanghai");
        queue.add("Anhui");

        queue.offer("Beijing");

        System.out.println("First element of queue:" + queue.peek());
        System.out.println("First element of queue:" + queue.peek());

        queue.remove();
        queue.poll();
        System.out.println("First element of queue:" + queue.peek());
    }
}
