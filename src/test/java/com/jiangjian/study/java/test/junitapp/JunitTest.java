package com.jiangjian.study.java.test.junitapp;

import com.jiangjian.study.java.advanced.crypto.AESCoderTest;
import org.junit.runner.*;

public class JunitTest {
    public static void main(String[] args) {
        JUnitCore.main("com.jiangjian.study.java.test.junitapp.EveryMethodNewTestInstance");
        new JUnitCore().run(org.junit.runner.Request.method(EveryMethodNewTestInstance.class, "test1"));
    }
}
