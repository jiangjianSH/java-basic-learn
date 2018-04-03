package com.jiangjian.study.java.junitapp;

import org.junit.Test;

public class EveryMethodNewTestInstance {
    public EveryMethodNewTestInstance() {
        System.out.println("整的假的");
    }

    @Test
    public void test1() {
        System.out.println("测试1");
    }

    @Test
    public void test2() {
        System.out.println("测试2");
    }
}
