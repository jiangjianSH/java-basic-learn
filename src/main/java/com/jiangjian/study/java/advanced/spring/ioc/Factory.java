package com.jiangjian.study.java.advanced.spring.ioc;


public class Factory {
    public Car getCar(String name, String manufacturer) {
        Car car = new Car();
        car.setManufacturer(manufacturer);
        car.setName(name);
        return car;
    }
}
