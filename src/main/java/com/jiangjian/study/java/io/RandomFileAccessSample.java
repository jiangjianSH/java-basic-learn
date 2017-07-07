package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class RandomFileAccessSample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("a.txt", "rw");
        randomAccessFile.seek(10);
        int a = randomAccessFile.read();
        while(a != -1) {
            System.out.print((char)a);
            a = randomAccessFile.read();
        }
    }
}
