package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.*;
import java.math.BigDecimal;

public class ClassAnalysis {
    public static void displayMethodInfo(Class clazz) {
        Method method = null;

    }

    public static void displayFieldsInfo(Object target) throws IllegalAccessException, NoSuchMethodException {
        Class clazz = target.getClass();
        while(true) {
            if (clazz == null) {
                break;
            }
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor constructor : constructors) {

            }
             if (clazz.isArray()) {
                clazz = clazz.getComponentType();
                if (Array.getLength(target) == 0) {
                    return;
                }
                for(int i = 0; i < Array.getLength(target); i++) {
                    Field[] fields = clazz.getDeclaredFields();
                    for(Field field : fields) {
                        displayFiledDetail(field, Array.get(target, i));
                    }
                }
            } else {
                Field[] fields = clazz.getDeclaredFields();
                for(Field field : fields) {
                    displayFiledDetail(field, target);
                }
                clazz = clazz.getSuperclass();
            }
        }
    }

    private static void displayFiledDetail(Field field, Object target) throws IllegalAccessException {
        System.out.println("字段名称: " + field.getName());
        System.out.println("字段类型: " + field.getType().getCanonicalName());
        System.out.println("字段所在类: " + field.getDeclaringClass().getCanonicalName());
        System.out.println("字段访问权限: " + Modifier.toString(field.getModifiers()));
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
        System.out.println("字段值: " + field.get(target));
        System.out.println();
    }
    public static void main(String[] args) throws IllegalAccessException {
//        displayFieldsInfo(new Child[]{});
    }
}
