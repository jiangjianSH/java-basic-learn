package com.jiangjian.study.java.designpattern.behavior.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        Food food = new Food(10000);
        Car car = new Car(200000);
        Cigarette cigarette = new Cigarette(1000);

        ChinaTaxCal chinaTaxCal = new ChinaTaxCal();
        System.out.println("---------------China Tax-----------------------");
        System.out.println("China food: " + food.accept(chinaTaxCal));
        System.out.println("China car: " + car.accept(chinaTaxCal));
        System.out.println("China cigarette: " + cigarette.accept(chinaTaxCal));

        System.out.println("---------------USA Tax-----------------------");
        USATaxCal usaTaxCal = new USATaxCal();
        System.out.println("USA food: " + food.accept(usaTaxCal));
        System.out.println("USA car: " + car.accept(usaTaxCal));
        System.out.println("USA cigarette: " + cigarette.accept(usaTaxCal));
    }
}
