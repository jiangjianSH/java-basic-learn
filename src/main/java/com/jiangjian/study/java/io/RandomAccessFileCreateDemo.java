package com.jiangjian.study.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileCreateDemo {
    public static void main(String[] args) throws IOException {
        new File("r.txt").delete();
        RandomAccessFile temp = new RandomAccessFile("r.txt", "rw");
        temp.writeInt(8);

        temp.seek(0);
        temp.writeInt(9);

        temp.seek(0);
        int value = temp.readInt();
        System.out.println(value);
        temp.setLength(20);
        temp.close();
    }
}
