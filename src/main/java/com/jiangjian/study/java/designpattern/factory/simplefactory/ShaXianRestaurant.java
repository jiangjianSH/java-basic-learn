package com.jiangjian.study.java.designpattern.factory.simplefactory;

public class ShaXianRestaurant {
    public static void main(String[] args) {
        //顾客定一份鱼香肉丝面
        Food food = Kitchen.orderFoond("鱼香肉丝面");
        food.prepare();
        food.cook();
        food.eat();
        System.out.println("----------------------");

        //顾客定一份青椒肉丝面
        food = Kitchen.orderFoond("青椒肉丝面");
        food.prepare();
        food.cook();
        food.eat();
    }
}
