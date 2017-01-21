package com.jiangjian.study.java.io;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class CharArrayWriterSample {
    public static void main(String[] args) {
        CharArrayWriter arrayWriter = new CharArrayWriter();
        try {
            arrayWriter.write("jiangjain");
            char[] data = arrayWriter.toCharArray();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
