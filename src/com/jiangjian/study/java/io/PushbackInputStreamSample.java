package com.jiangjian.study.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class PushbackInputStreamSample {
    public static void main(String[] args) throws IOException {
        PushbackInputStream inputStream = new PushbackInputStream(new FileInputStream("article.sql"));
        int data = inputStream.read();
        System.out.println((char)data);
        inputStream.unread(data);
        data = inputStream.read();
        System.out.println((char)data);
    }
}
