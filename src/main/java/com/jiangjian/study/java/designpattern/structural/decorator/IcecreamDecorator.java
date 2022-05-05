package com.jiangjian.study.java.designpattern.structural.decorator;

public class IcecreamDecorator extends CakeDecorator{
    public IcecreamDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public void addDecorator() {
        System.out.println("包含：冰淇淋奶油");
    }
}
