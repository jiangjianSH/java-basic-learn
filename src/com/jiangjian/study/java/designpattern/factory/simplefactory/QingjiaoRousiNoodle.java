package com.jiangjian.study.java.designpattern.factory.simplefactory;

public class QingjiaoRousiNoodle implements Food {
    @Override
    public void prepare() {
        System.out.println("准备青椒丝面需要的食材");
    }

    @Override
    public void cook() {
        System.out.println("烹煮青椒肉丝面");
    }

    @Override
    public void eat() {
        System.out.println("吃青椒肉丝面...");
    }
}
