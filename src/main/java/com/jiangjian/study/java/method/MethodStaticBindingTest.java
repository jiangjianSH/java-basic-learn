package com.jiangjian.study.java.method;

import java.util.Collection;
import java.util.HashSet;

public class MethodStaticBindingTest {

    public static void main(String[] args) {
        Collection c = new HashSet();
        MethodStaticBindingTest et = new MethodStaticBindingTest();
        et.sort(c);
    }

    public Collection sort(Collection c) {
        System.out.println("Inside Collection sort method");
        return c;
    }

    public Collection sort(HashSet hs) {
        System.out.println("Inside HashSet sort method");
        return hs;
    }
}

