package com.jiangjian.study.java;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String s = "ﾖ"; //0xFF6E
        char a = '杨';
        System.out.println(s.getBytes("UTF-16").length);//length of the string
        System.out.println(s.charAt(0));//first character in the string
//        System.out.println(Integer.getChars(12345, 2, new char[100]));
    }
}
