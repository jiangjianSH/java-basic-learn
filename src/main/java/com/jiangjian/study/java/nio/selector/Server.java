package com.jiangjian.study.java.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    static ByteBuffer bb = ByteBuffer.allocateDirect(8);

    static int port = 8989;

    public static void main(String[] args) {
        System.out.println("Server starting ... listening on port " + port);
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket ss = serverSocketChannel.socket();
            ss.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);

            Selector s = Selector.open();
            SelectionKey key1 = serverSocketChannel.register(s, SelectionKey.OP_ACCEPT);

            while(true) {
                int n = s.select();
                if (n == 0) {
                    System.out.println("#############");
                    continue;
                }
                Iterator<SelectionKey> i = s.selectedKeys().iterator();
                while (i.hasNext()) {
                    SelectionKey key  = i.next();
                    System.out.println("key equals : " + (key == key1));
                    if(key.isAcceptable()) {
                        SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
                        if(sc == null) {
                            continue;
                        }
                        System.out.println("Receiving connection");
                        bb.clear();
                        bb.putLong(System.currentTimeMillis());
                        bb.flip();
                        while(bb.hasRemaining()) {
                            sc.write(bb);
                        }
                        sc.close();
                    }
                    i.remove();
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
