package com.jiangjian.study.java.advanced.reflection;

public class StacktraceDemo {

    public static void main(String[] args) {

        demo();
    }

    public static void demo() {
        StackTraceElement[] es = new Throwable().getStackTrace();
        Throwable t2 = new NullPointerException();
        System.out.println(t2.getClass().getName());
        for(StackTraceElement stackTraceElement : es) {
            System.out.println(stackTraceElement.getClassName());
            System.out.println(stackTraceElement.getMethodName());
            System.out.println(stackTraceElement.getFileName());
            System.out.println(stackTraceElement.getLineNumber());
            System.out.println("-------------------------------");
        }
    }
}
