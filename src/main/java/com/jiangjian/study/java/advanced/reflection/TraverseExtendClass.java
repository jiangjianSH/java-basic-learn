package com.jiangjian.study.java.advanced.reflection;

import org.springframework.cache.annotation.SpringCacheAnnotationParser;

public class TraverseExtendClass extends SpringCacheAnnotationParser {
    public static void main(String[] args) {
        Class clazz = TraverseExtendClass.class.getSuperclass();
        while(true) {
            if (clazz == null) {
                break;
            }
            System.out.println("---->" + clazz.getName());
            clazz = clazz.getSuperclass();
        }
    }
}
