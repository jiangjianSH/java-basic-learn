package com.jiangjian.study.java.advanced.jvm.basic.proxy;

import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Tracing implements InvocationHandler {
    private Object target;

    private PrintStream out;

    public Tracing(Object target, PrintStream out) {
        this.target = target;
        this.out = out;
    }

    public static Object createProxy(Object object, PrintStream out) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new Tracing(object, out));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        out.println(method.getName() + "(...) called");
        try {
            result = method.invoke(target, args);
        } catch (InvocationTargetException e) {
            out.println(method.getName() + " throws " + e.getCause());
            throw e.getCause();
        }
        out.println(method.getName() + " returns");
        return result;
    }

    public static void main(String[] args) {
        Operation a = new Operation() {
            @Override
            public void doBusiness() {
                System.out.println("业务操作");
            }
        };

        Operation proxy = (Operation) createProxy(a, System.out);
        proxy.doBusiness();
    }
}
