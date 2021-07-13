package com.jiangjian.study.java.designpattern.behavior.visitor;

public interface Visitor {
    double visit(Food food);

    double visit(Car car);

    double visit(Cigarette cigarette);
}
