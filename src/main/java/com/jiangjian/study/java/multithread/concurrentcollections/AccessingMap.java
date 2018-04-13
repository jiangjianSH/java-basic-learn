package com.jiangjian.study.java.multithread.concurrentcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccessingMap {
    private static void userMap(final Map<String, Integer> scores) {
        scores.put("Fred", 10);
        scores.put("Sara", 12);
        try {
            for (final String key : scores.keySet()) {
                System.out.println(key + "score " + scores.get(key));
                scores.put("Joe", 14);
            }
        }catch (Exception ex) {
            System.out.println("Failed: " + ex);
        }
        System.out.println("map size:" + scores.size());
    }

    public static void main(String[] args) {
        System.out.println("Using Plain vanilla HashMap");
        userMap(new HashMap<>());


        System.out.println("Using synchronizedMap HashMap");
        userMap(Collections.synchronizedMap(new HashMap<>()));

        System.out.println("Using Concurrent HashMap");
        userMap(new ConcurrentHashMap<>());
    }
}
