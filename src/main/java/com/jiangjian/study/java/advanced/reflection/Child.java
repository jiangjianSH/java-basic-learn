package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Child extends Parent {
    private String a = "a";

    @Override
    void display() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        Parent parent = child;
        parent.display();
        Field[] fields = child.getClass().getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field);
        }
    }
}
