package com.jiangjian.study.java.designpattern.structural.decorator;

abstract public class CakeDecorator implements Cake{
    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    abstract  public void addDecorator();

    @Override
    public void desc() {
        addDecorator();
        cake.desc();
    }
}
