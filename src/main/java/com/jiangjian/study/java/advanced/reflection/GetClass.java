package com.jiangjian.study.java.advanced.reflection;

public class GetClass {
    public static void main(String[] args) {
        Class arrayClass= int[][][].class;
        System.out.println(arrayClass.getName());

        Class[] aa = String.class.getDeclaredClasses();
        for(Class a: aa) {
            System.out.println(a.getName());
        }

        String a = "1" + "2";
        String b = "12";
        String c = new String("12");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

        Integer f= 100;
        Integer g = 100;
        System.out.println(f==g);
    }
}
