package com.jiangjian.study.java.advanced.jvm.basic.classloader.dynamicextension;

import java.util.Date;

public class HiTime implements Greeter{
    @Override
    public void greet() {
        Date date = new Date();
        int hours = date.getHours();
// Some hours: midnight, 0; noon, 12; 11PM, 23;
        if (hours >= 4 && hours <= 11) {
            System.out.println("Good morning, world!");
        }
        else if (hours >= 12 && hours <= 16) {
            System.out.println("Good afternoon, world!");
        }
        else if (hours >= 17 && hours <= 21) {
            System.out.println("Good evening, world!");
        }
        else if (hours >= 22 || hours <= 3) {
            System.out.println("Good night, world!");
        }
        else {
// This should never happen.
            System.out.println("Oh oh, the clock is broken, world!");
        }
    }
}
