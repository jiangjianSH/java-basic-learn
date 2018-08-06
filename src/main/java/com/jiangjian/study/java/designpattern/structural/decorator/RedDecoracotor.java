package com.jiangjian.study.java.designpattern.structural.decorator;

public class RedDecoracotor extends ShapeDecorator {
    public RedDecoracotor(Shape decoratedTarget) {
        super(decoratedTarget);
    }

    @Override
    public void beforeDraw() {
        System.out.println("add red color");
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        new RedDecoracotor(circle).draw();
    }
}
