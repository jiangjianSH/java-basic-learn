package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Version(version = 2)
@Author(author = "姜健")
public class Bar {

    @SecurityField(level = 3)
    private String password;

    @UnsensitiveField(category = "兴趣")
    private String hobby;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for(Annotation annotation : Bar.class.getAnnotations()) {
           printAnnotationFieldInfo(annotation);
        }

        for(Field field : Bar.class.getDeclaredFields()) {
            Annotation[] annotations = field.getAnnotations();
            for(Annotation annotation : annotations) {
                System.out.println("字段:" + field.getName() + " 存在注解:" + annotation.annotationType().getName());
                printAnnotationFieldInfo(annotation);
            }
        }
    }

    public static void printAnnotationFieldInfo(Annotation annotation) throws InvocationTargetException, IllegalAccessException {
        Class<? extends Annotation> type = annotation.annotationType();
        System.out.println("Values of " + type.getName());
        for(Method method : type.getDeclaredMethods()) {
            Object value = method.invoke(annotation, (Object[]) null);
            System.out.println(" " + method.getName() + ":" + value);
        }

    }
}
