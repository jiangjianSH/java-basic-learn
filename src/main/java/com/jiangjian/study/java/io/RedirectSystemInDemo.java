package com.jiangjian.study.java.io;

import java.io.FileInputStream;
import java.io.IOException;

public class RedirectSystemInDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("pom.xml");
        System.setIn(is);

        int ch = System.in.read();
        while(ch != -1) {
            System.out.print((char)ch);
            ch = System.in.read();
        }

        is.close();

    }
}
