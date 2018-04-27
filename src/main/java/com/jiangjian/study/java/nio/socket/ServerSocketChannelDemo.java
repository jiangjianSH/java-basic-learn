package com.jiangjian.study.java.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress("localhost", 9090));

            while(true) {
                SocketChannel sc = ssc.accept();
                if(sc == null) {
                    System.out.println("No connection, just sleep");
                    Thread.sleep(1000L);
                } else {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                    byteBuffer.clear();
                    byteBuffer.put("I am server, nice to meet you".getBytes());
                    byteBuffer.flip();
                    int a = sc.write(byteBuffer);
                    System.out.println("write size: " + a);
                    sc.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
