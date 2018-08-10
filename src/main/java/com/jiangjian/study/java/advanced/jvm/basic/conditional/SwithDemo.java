package com.jiangjian.study.java.advanced.jvm.basic.conditional;

public class SwithDemo {
    public static void main(String[] args) {
        Sex sex = Sex.BOY;
        switch (sex) {
            case BOY:
            System.out.println("A");
            break;
            case GRIL:
                System.out.println("B");
        }
    }
    enum Sex {
        BOY,
        GRIL;
    }
}
