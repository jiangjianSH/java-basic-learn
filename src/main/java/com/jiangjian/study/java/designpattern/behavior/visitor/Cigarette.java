package com.jiangjian.study.java.designpattern.behavior.visitor;

public class Cigarette implements Visitable{
    private double price;

    public Cigarette(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
