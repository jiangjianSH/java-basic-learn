package com.jiangjian.study.java.nio.asynochronous.socket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class Server {
    public static void main(String[] args) {
        try {
            AsynchronousServerSocketChannel channelServer = AsynchronousServerSocketChannel.open();
            channelServer.bind(new InetSocketAddress(7878));
            System.out.printf("Server listening at %s%n", channelServer.getLocalAddress());

            Attachment attachment = new Attachment();
            attachment.channelServer = channelServer;
            channelServer.accept(attachment,  new ConnectionHandler());

            Thread.currentThread().join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
