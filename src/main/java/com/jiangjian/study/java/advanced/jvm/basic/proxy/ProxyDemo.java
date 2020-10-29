package com.jiangjian.study.java.advanced.jvm.basic.proxy;

import java.lang.reflect.*;

public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        Object proxy = methodOne();
        System.out.println(Proxy.isProxyClass(proxy.getClass()));

    }

    public static Object methodOne() throws Exception{
        Class clazz = Proxy.getProxyClass(ProxyDemo.class.getClassLoader(), new Class[]{Operation.class});
        Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("啥也不做");
                return null;
            }
        });
        return proxy;
    }

    public static Object methodTwo() {
        Object proxy = Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Operation.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("啥也不做");
                return null;
            }
        });
        return proxy;
    }
}
