package com.jiangjian.study.java.designpattern.structural.decorator;

public class PrincessToyDecorator extends CakeDecorator{
    public PrincessToyDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public void addDecorator() {
        System.out.println("包含：公主玩具饰品");
    }
}
