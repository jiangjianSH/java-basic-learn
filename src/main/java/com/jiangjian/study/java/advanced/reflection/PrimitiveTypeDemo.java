package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitiveTypeDemo {
    public void say() {
        System.out.println("hi");
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = PrimitiveTypeDemo.class;
        Method method = clazz.getMethod("say", null);
        PrimitiveTypeDemo t = new PrimitiveTypeDemo();
        method.invoke(t, null);
        System.out.println(Class.class.isInstance(Class.class));
    }
}
