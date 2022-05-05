package com.jiangjian.study.java;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String a = "a";
        String b = "a";
        System.out.println(a == b);

        String c = "姜健";
        String d = "姜健";
        System.out.println(c == d);
    }
}
