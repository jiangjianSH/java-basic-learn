package com.jiangjian.study.java.advanced.reflection;

import sun.plugin.dom.core.Document;
import sun.plugin.dom.core.Element;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FieldDemo {
    public static void main(String[] args) {
        System.out.println(Modifier.toString(Member.class.getModifiers()));
    }



    public static Field[] getInstanceVariables(Object obj) {
        Class cls = obj.getClass();
        List accum = new LinkedList<Field>();
        while (cls != null) {
            Field[] f = cls.getDeclaredFields();
            for(Field field : f) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    accum.add(field);
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
            }
            cls = cls.getSuperclass();
        }
        return (Field[]) accum.toArray(new Field[accum.size()]);
    }
}
