package com.jiangjian.study.java.designpattern.behavior.visitor;

public class USATaxCal implements Visitor{
    @Override
    public double visit(Food food) {
        return food.getPrice() * 0.01;
    }

    @Override
    public double visit(Car car) {
        return car.getPrice() * 0.01;
    }

    @Override
    public double visit(Cigarette cigarette) {
        return cigarette.getPrice() * 0.02;
    }
}
