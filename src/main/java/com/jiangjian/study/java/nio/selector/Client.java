package com.jiangjian.study.java.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Client {
    static ByteBuffer bb = ByteBuffer.allocateDirect(8);

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8989));
        long time = 0;
        while(sc.read(bb) != -1) {
            bb.flip();
            while(bb.hasRemaining()) {
                time <<= 8;
                time |= bb.get() & 255;
            }
            bb.clear();
        }
        System.out.println(new Date(time));
        sc.close();
    }
}
