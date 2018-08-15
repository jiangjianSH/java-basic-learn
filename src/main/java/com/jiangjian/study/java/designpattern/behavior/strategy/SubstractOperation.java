package com.jiangjian.study.java.designpattern.behavior.strategy;

public class SubstractOperation implements MathOperation {
    @Override
    public int operation(int x, int y) {
        return x - y;
    }
}
