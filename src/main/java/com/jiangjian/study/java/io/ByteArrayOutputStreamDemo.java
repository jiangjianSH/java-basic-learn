package com.jiangjian.study.java.io;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        output.write(1);
        output.write(2);
        output.write(3);
        output.write(4);

        byte[] bytes = output.toByteArray();
        for(byte data : bytes) {
            System.out.println(data);
        }
    }
}
