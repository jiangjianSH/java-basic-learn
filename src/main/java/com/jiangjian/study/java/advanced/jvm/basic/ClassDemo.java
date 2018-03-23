package com.jiangjian.study.java.advanced.jvm.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.getClass().getName());

        Class c1 = s1.getClass();

        for(Method method: c1.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        for(Field field : c1.getDeclaredFields()) {
            System.out.println(field.getName());
        }

        Student s2 = new Student();
        Class c2 = s2.getClass();
        System.out.println(c1 == c2);

        System.gc();
    }
}
