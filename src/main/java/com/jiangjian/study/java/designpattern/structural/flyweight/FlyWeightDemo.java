package com.jiangjian.study.java.designpattern.structural.flyweight;

public class FlyWeightDemo {
    public static void main(String[] args) {
        Integer one = Integer.valueOf(2);
        Integer two = Integer.valueOf(2);
        System.out.println(one == two);
    }
}
