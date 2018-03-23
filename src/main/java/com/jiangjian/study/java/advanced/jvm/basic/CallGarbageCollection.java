package com.jiangjian.study.java.advanced.jvm.basic;

public class CallGarbageCollection {
    public static void main(String[] args) throws InterruptedException {
        CallGarbageCollection test1 = new CallGarbageCollection();
        CallGarbageCollection test2 = new CallGarbageCollection();

        test1 = null;
        System.gc();

        test2 = null;
        Runtime.getRuntime().gc();

        Thread.sleep(200000L);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
}

