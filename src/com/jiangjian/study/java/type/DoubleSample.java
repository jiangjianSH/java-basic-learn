package com.jiangjian.study.java.type;

import java.text.DecimalFormat;

public class DoubleSample {
    public static void main(String[] args) {
        double i = 12.644545454544;
        DecimalFormat dec = new DecimalFormat("#.00");
        System.out.println(dec.format(i));
    }
}
