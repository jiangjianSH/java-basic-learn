package com.jiangjian.study.java.advanced.jvm.basic.integerarthemetic;

/**
 * short range from -32768 ~ +32767
 * @author jiangjian
 */
public class ShortTypeRangeTest {
    public static void main(String[] args) {
        short a = 32767;
        short b = (short)(a + 1);
        System.out.println(b);
    }
}
