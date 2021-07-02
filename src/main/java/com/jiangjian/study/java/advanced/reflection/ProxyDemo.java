package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.*;
import java.util.concurrent.Callable;

public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cl = Proxy.getProxyClass(ProxyDemo.class.getClassLoader(), new Class[] {Callable.class});
        System.out.println("proxy class name: " + cl.getName());

        Constructor cons = cl.getConstructor(new Class[]{InvocationHandler.class});
        InvocationHandler ih = (proxy, method, args1) -> {
            System.out.println("调用成功");
            return null;
        };
        Callable callable = (Callable) cons.newInstance(new Object[]{ih});
        callable.call();

        System.out.println("cl is proxy class: " + Proxy.isProxyClass(cl));
        if (Proxy.isProxyClass(cl)) {
            System.out.println("invocation handler is equal: " + (ih == Proxy.getInvocationHandler(callable)));
        }
    }
}
