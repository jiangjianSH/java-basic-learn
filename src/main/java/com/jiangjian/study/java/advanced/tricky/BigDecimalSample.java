package com.jiangjian.study.java.advanced.tricky;

import java.math.BigDecimal;

public class BigDecimalSample {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.00");
        System.out.println(a.compareTo(BigDecimal.ZERO) == 0);
    }
}
