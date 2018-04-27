package com.jiangjian.study.java.nio.datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.bind(new InetSocketAddress(9988));
            ByteBuffer symbol = ByteBuffer.allocate(4);
            ByteBuffer payload = ByteBuffer.allocate(16);
            while(true) {
                symbol.clear();
                payload.clear();
                SocketAddress sa = datagramChannel.receive(symbol);
                if(sa == null) return;
                System.out.println("Received request from " + sa);
                String stockSymbol = new String(symbol.array(), 0, 4);
                System.out.println("Symbol: " + stockSymbol);
                payload.putFloat(0, 37.40f);
                payload.putFloat(1, 23.54f);
                payload.putFloat(2, 44.23f);
                payload.putFloat(3, 99.22f);
                datagramChannel.send(payload, sa);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
