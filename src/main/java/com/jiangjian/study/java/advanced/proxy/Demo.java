package com.jiangjian.study.java.advanced.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List proxy = (List )Proxy.newProxyInstance(Demo.class.getClassLoader(),
                new Class[] {List.class}, new NoOpAddInvocationHandler(list));
        proxy.add("a");
        System.out.println(list.size());
    }
}
