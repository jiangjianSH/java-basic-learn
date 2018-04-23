package com.jiangjian.study.java.formatter;

import java.util.Locale;

public class FormatterEmployee {
    public static void main(String[] args) {
        Employee employee =new Employee("姜健", 1000);
        System.out.printf("[%s]%n", employee);
        System.out.printf(Locale.FRENCH, "[%s]%n", employee);
        System.out.printf("[%S]%n", employee);
        System.out.printf("[%10.3s]%n", employee);
        System.out.printf("[%-10.3s]%n", employee);
        System.out.printf("[%#s]%n", employee);

    }
}
