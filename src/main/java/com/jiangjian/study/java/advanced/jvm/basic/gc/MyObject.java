package com.jiangjian.study.java.advanced.jvm.basic.gc;

/**
 * @author jiangjian
 */
public class MyObject {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize called");
    }

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            new MyObject();
        }
    }
}
