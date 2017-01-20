package com.jiangjian.study.java.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class SequenceInputStreamSample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream1 = new FileInputStream("article.sql");
        InputStream inputStream2 = new FileInputStream("b.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        int data = sequenceInputStream.read();
        while(data != -1) {
            System.out.print((char) data);
            data = sequenceInputStream.read();
        }
        sequenceInputStream.close();

    }

}
