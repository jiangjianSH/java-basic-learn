package com.jiangjian.study.java.nio.asynochronous.socket.server;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ConnectionHandler implements CompletionHandler<AsynchronousSocketChannel, Attachment> {
    @Override
    public void completed(AsynchronousSocketChannel channelClient, Attachment attachment) {
        try {
            SocketAddress clientAddr = channelClient.getRemoteAddress();
            System.out.printf("Accepted connection from %s%n", clientAddr);
            attachment.channelServer.accept(attachment, this);

            Attachment newAttr = new Attachment();
            newAttr.channelServer = attachment.channelServer;
            newAttr.channelClient = channelClient;
            newAttr.isReadMode = true;
            newAttr.buffer = ByteBuffer.allocate(2048);
            newAttr.clientAddr = clientAddr;
            ReadWriteHandler rwh = new ReadWriteHandler();
            channelClient.read(newAttr.buffer, newAttr, rwh);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("Failed to accept connection");
    }
}
