package com.jiangjian.study.java.designpattern.creational.simplefactory;

public class Kitchen {
    public static Food orderFoond(String name) {
        if("鱼香肉丝面".equals(name)) {
            return new YuxiangRousiNoodle();
        } else  if("青椒肉丝面".equals(name)) {
            return new QingjiaoRousiNoodle();
        }
        return null;
    }
}
