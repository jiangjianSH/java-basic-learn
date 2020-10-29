package com.jiangjian.study.java.advanced.jvm.basic.gc;

import java.util.HashSet;

public class Demo {
    private static void createFewLongLivedAndManyShortLivedObjects() {
        HashSet<Double> set = new HashSet<Double>();

        long l = 0;
        for (int i=0; i < 100; i++) {
            Double longLivedDouble = new Double(l++);
            set.add(longLivedDouble);  // add to Set so the objects continue living outside the scope
        }

        while(true) { // Keep creating short-lived objects. Extreme but illustrates the point
            Double shortLivedDouble = new Double(l++);
        }
    }

    private static void createManyShortLivedObjects() {
        final int NUMBER_OF_THREADS = 100;
        final int NUMBER_OF_OBJECTS_EACH_TIME = 1000000;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(() -> {
                while (true) {
                    for (int j = 0; j < NUMBER_OF_OBJECTS_EACH_TIME;  j++) {
                        Double shortLivedDouble = new Double(1.0d);
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }
    }

    public static void main(String[] args) {
//        createFewLongLivedAndManyShortLivedObjects();
        createManyShortLivedObjects();
    }
}
