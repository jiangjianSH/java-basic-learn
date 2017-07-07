package com.jiangjian.study.java.io;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class CharArrayReaderSample {
    public static void main(String[] args) throws IOException {
        CharArrayReader charArrayReader = new CharArrayReader("今天是一个好日子".toCharArray());
        int data = charArrayReader.read();
        while(data != -1) {
            System.out.print((char) data);
            data = charArrayReader.read();
        }
    }
}
