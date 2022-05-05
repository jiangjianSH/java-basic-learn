package com.jiangjian.study.java.advanced.netty.tutorial.transport;

import io.netty.buffer.ByteBuf;
import org.hibernate.sql.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class PlainNioServer {
    public void serve(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket ssocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ssocket.bind(address);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("hi!\r\n".getBytes());
        for(;;) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
                        System.out.println("Accepted connection from " + client);
                    }

                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        while(buffer.hasRemaining()) {
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client.close();
                    }
                }  catch (IOException e) {
                    e.printStackTrace();
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainNioServer().serve(8888);
    }
}
