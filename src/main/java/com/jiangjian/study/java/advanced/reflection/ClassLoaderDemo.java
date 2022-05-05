package com.jiangjian.study.java.advanced.reflection;

import com.sun.javafx.binding.Logging;

import java.util.ArrayList;

public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        printClassLoaders();
    }

    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + ClassLoaderDemo.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
