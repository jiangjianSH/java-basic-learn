package com.jiangjian.study.java.io;

import java.io.StringWriter;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
public class StringWriterSample {
    public static void main(String[] args) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("java");
        System.out.println(stringWriter.toString());
    }
}
