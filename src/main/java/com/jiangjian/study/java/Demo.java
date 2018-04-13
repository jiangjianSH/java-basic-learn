package com.jiangjian.study.java;

public class Demo {
    public static void main(String[] args) {
        Integer a = 40;
        Integer b = 40;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        Integer c1 = -128;
        Integer d1 = -128;
        System.out.println(c1 == d1);

        Integer c2 = -129;
        Integer d2 = -129;
        System.out.println(c2 == d2);

        String str1 = "123";
        String str2 = "123";
        String str3 = "1" + "23";
        String str4 = new String("123");
        String str5 = str4.intern();

        System.out.println(str5 == str3);
//        System.out.println(str2 == str3);


    }
}
