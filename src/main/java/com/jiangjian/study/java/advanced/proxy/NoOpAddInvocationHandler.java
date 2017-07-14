package com.jiangjian.study.java.advanced.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class NoOpAddInvocationHandler implements InvocationHandler{
    private List list;

    public NoOpAddInvocationHandler(List list) {
        this.list = list;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("add")) {
            return false;
        }
        return method.invoke(list, args);
    }
}
