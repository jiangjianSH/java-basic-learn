package com.jiangjian.study.java.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            boolean connectSuccess = sc.connect(new InetSocketAddress("localhost", 9090));
            while(!connectSuccess) {
                while(!sc.finishConnect()) {
                    System.out.println("Sleep for a while to connect server");
                    Thread.sleep(2000L);
                }
                break;
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(200);
            while(sc.read(byteBuffer) >= 0) {
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
