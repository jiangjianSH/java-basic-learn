package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new SimpleInvocationHandler();
        BusinessOps businessOpsProxy = (BusinessOps) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{BusinessOps.class}, invocationHandler);
        System.out.println(Proxy.isProxyClass(businessOpsProxy.getClass()));
        System.out.println(invocationHandler == Proxy.getInvocationHandler(businessOpsProxy));
        businessOpsProxy.sum(1, 2);
    }
}
