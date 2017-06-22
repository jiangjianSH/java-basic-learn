package com.jiangjian.study.java.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

public class CharArrayReaderDemo {
    public static void main(String[] args) throws IOException {
        char[] chars = {'a', 'b', 'c'};
        Reader reader = new CharArrayReader(chars);
        int data =  reader.read();
        while(data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

        System.out.println("\n");
        chars = "0123456789".toCharArray();
        reader = new CharArrayReader(chars, 2, 3);
        data =  reader.read();
        while(data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }
    }
}
