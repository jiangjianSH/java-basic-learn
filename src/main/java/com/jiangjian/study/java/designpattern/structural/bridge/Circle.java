package com.jiangjian.study.java.designpattern.structural.bridge;

public class Circle extends Shape{
    private int x, y, radius;

    protected Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }

    public static void main(String[] args) {

        Shape redCircle = new Circle(new RedCircle(), 100,100, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 100,100, 10);

        redCircle.draw();
        greenCircle.draw();
    }
}
