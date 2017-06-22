package com.jiangjian.study.java.advanced.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderSample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("Start Program");
        MyClassLoader myClassLoader = new MyClassLoader(ClassLoaderSample.class.getClassLoader());
        Class cls= myClassLoader.loadClass("com.jiangjian.study.java.multithread.JoinSample");
        Method outputClassLoader = cls.getMethod("outputClassLoader", null);
        outputClassLoader.invoke(null, new Object[0]);
        System.out.println("Exit Program");
    }
}
