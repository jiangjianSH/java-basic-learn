package com.jiangjian.study.java;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class GsonTest {
    public static void main(String[] args) {
        Date a = new Date();
        System.out.println(a);
        System.out.println(new Gson().toJson(a));

        DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        System.out.println(b.format(a));
    }
}
