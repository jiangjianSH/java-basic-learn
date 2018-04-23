package com.jiangjian.study.java.io;

import java.io.IOException;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        System.out.print("this is one line\n");
        System.out.println("this is second line");

        char j = (char) System.in.read();
        System.out.println(j);
    }
}
