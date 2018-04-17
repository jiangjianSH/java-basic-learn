package com.jiangjian.study.java.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("writesomebytes.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] message = "I love china".getBytes();
        for(int i = 0; i < message.length; i++) {
            byteBuffer.put(message[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);
    }
}
