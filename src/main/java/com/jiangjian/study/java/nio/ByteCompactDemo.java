package com.jiangjian.study.java.nio;

import java.nio.ByteBuffer;

public class ByteCompactDemo {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(7);

        bf.put((byte) 10).put((byte) 20).put((byte) 30);
        bf.flip();

        bf.get();
        System.out.println(bf.position());
        System.out.println(bf.limit());

        bf.compact();
        System.out.println(bf.position());
        System.out.println(bf.limit());
        bf.put(2, (byte) 0);
        ByteBuffer bf1 = ByteBuffer.allocate(7);
        bf1.put((byte) 20).put((byte) 30);
        System.out.println(bf.remaining());
        System.out.println(bf1.remaining());
        System.out.println(bf.equals(bf1));
        System.out.println(bf.compareTo(bf1));
    }
}
