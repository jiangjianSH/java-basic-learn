package com.jiangjian.study.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[4];
        bytes[0] = 1;
        bytes[1] = 2;
        bytes[2] = 3;
        bytes[3] = 4;

        InputStream input = new ByteArrayInputStream(bytes);
        int data = input.read();
        while(data != -1) {
           System.out.println(data);
            data = input.read();
        }

    }

}
