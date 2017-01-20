package com.jiangjian.study.java.designpattern.factory.simplefactory;

public class YuxiangRousiNoodle implements Food {
    @Override
    public void prepare() {
        System.out.println("准备鱼香肉丝面需要的食材");
    }

    @Override
    public void cook() {
        System.out.println("烹煮鱼香肉丝面");
    }

    @Override
    public void eat() {
         System.out.println("吃鱼香肉丝面...");
    }
}
