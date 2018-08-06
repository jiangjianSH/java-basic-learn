package com.jiangjian.study.java.designpattern.structural.decorator;

abstract public class ShapeDecorator implements Shape {
    private Shape decoratedTarget;

    public ShapeDecorator(Shape decoratedTarget) {
        this.decoratedTarget = decoratedTarget;
    }

    public void beforeDraw(){
        //no op
    }

    public void draw(){
        beforeDraw();
        decoratedTarget.draw();
        afterDraw();
    }

    public void afterDraw(){
        //no op
    }
}
