package com.jiangjian.study.java.advanced.reflection;


import java.lang.reflect.Array;
import java.util.Collection;

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] strArr = (String[]) Array.newInstance(String.class, 5);
        System.out.println("string array length: " + strArr.length);


        Class booleanClass = Class.forName("[Z");
        System.out.println("'[Z' represent array class : " + booleanClass.isArray());
        System.out.println("'[Z' component type class : " + booleanClass.getComponentType().getName());
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int size(Collection t) {
        return t.size();
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public int sumArray(int[] datas) {
        int sum = 0;
        for(int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum;
    }


}
