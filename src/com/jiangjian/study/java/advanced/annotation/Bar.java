package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Version(version = 2)
public class Bar {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for(Annotation annotation : Bar.class.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            System.out.println("Values of " + type.getName());
            for(Method method : type.getDeclaredMethods()) {
                Object value = method.invoke(annotation, (Object[]) null);
                System.out.println(" " + method.getName() + ":" + value);
            }
        }
    }

}
