package com.jiangjian.study.java.designpattern.creational.builder;


public class CarBuilder {
    private Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder setColor(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder setSeatSize(String size) {
        car.setSeatNum(size);
        return this;
    }

    public CarBuilder setPrice(String price) {
        car.setPrice(price);
        return this;
    }

    public Car build() {
        return car;
    }
}
