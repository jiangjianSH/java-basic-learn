package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
public class PushbackReaderSample {
    public static void main(String[] args) {
        try {
            PushbackReader pushbackReader = new PushbackReader(new FileReader("a.txt.bak"));
            int data = pushbackReader.read();
            System.out.println((char) data);
            pushbackReader.unread(data);
            data = pushbackReader.read();
            System.out.println((char) data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
