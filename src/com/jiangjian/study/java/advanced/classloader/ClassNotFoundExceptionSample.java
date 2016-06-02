package com.jiangjian.study.java.advanced.classloader;

/**
 * refer to http://javarevisited.blogspot.com/2012/12/how-classloader-works-in-java.html
 */
public class ClassNotFoundExceptionSample {
    public static void main(String[] args) {
        System.out.println("ClassNotFoundExceptionSample class loader: " + ClassNotFoundExceptionSample.class.getClassLoader());

        try {
            Class.forName("com.jiangjian.study.java.advanced.classloader.ClassNotFoundExceptionSample",
                    true, ClassLoaderSample.class.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
