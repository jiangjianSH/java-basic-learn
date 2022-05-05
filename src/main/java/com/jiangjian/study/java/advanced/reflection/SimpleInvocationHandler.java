package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SimpleInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call");
        method.invoke(proxy, args);
        System.out.println("after call");
        return proxy;
    }
}
