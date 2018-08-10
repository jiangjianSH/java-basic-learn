package com.jiangjian.study.java.designpattern.creational.builder;

public class Car {
    private String price;
    private String color;
    private String seatNum;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price='" + price + '\'' +
                ", color='" + color + '\'' +
                ", seatNum='" + seatNum + '\'' +
                '}';
    }
}
