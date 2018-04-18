package com.jiangjian.study.java.nio;

import java.nio.ByteBuffer;

public class ByteMarkDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7);
        byteBuffer.put((byte) 10).put((byte) 20).put((byte) 30).put((byte) 40);
        byteBuffer.limit(4);

        byteBuffer.position(1).mark().position(3);
        while(byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }        System.out.println();

        byteBuffer.reset();
        while(byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
