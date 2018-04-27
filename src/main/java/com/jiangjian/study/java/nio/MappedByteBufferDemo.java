package com.jiangjian.study.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("input.txt", "rw");
        FileChannel fileChannel = raf.getChannel();
        long size = fileChannel.size();
        System.out.println("Size: " +size);
        MappedByteBuffer mbb = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);
        while(mbb.hasRemaining()) {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print((char) mbb.get());
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < mbb.limit() / 2; i++) {
            byte b1 = mbb.get(i);
            byte b2 = mbb.get(mbb.limit() -i - 1);
            mbb.put(i, b2);
            mbb.put(mbb.limit() - i - 1, b1);
        }

        mbb.flip();
        while(mbb.remaining() > 0) {
            System.out.print((char)mbb.get());
        }
        fileChannel.close();
    }
}
