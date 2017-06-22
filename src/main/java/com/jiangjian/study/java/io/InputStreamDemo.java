package com.jiangjian.study.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("a.txt");
        int data = input.read();
        while(data != -1) {
            System.out.print((char) data);
            data = input.read();
        }
    }
}
