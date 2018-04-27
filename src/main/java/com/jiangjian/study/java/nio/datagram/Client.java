package com.jiangjian.study.java.nio.datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            ByteBuffer symbol = ByteBuffer.wrap("JJJJ".getBytes());
            ByteBuffer response = ByteBuffer.allocate(16);

            InetSocketAddress sa = new InetSocketAddress("192.168.101.199", 9988);
            datagramChannel.send(symbol, sa);
            System.out.println("Receiving datagram from " + datagramChannel.receive(response));
            System.out.println("Open price: " + response.getFloat(0));
            System.out.println("Low price: " + response.getFloat(4));
            System.out.println("High price: " + response.getFloat(8));
            System.out.println("Close price: " + response.getFloat(12));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
