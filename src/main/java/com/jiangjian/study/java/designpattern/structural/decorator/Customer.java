package com.jiangjian.study.java.designpattern.structural.decorator;

public class Customer {
    public static void main(String[] args) {
        Cake cake = new PrincessToyDecorator(new IcecreamDecorator(new RawCake()));
        cake.desc();
    }
}
