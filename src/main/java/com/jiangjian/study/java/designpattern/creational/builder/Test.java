package com.jiangjian.study.java.designpattern.creational.builder;

public class Test {
    public static void main(String[] args) {
        System.out.println(new CarBuilder().setColor("red").setPrice("1111").setSeatSize("4").build());
        System.out.println(new CarBuilder().setColor("blue").setPrice("22222").setSeatSize("2222").build());
    }
}
