package com.jiangjian.study.java.advanced.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReaderFile {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("a.txt");
        FileChannel fileChannel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(40);

    }
}
