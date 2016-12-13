package com.jiangjian.study.java.io;

import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        writer.write("abc");

        char[] chars = writer.toCharArray();
        for(char ch : chars) {
            System.out.print(ch);
        }
    }
}
