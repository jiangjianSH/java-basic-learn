package com.jiangjian.study.java.nio.asynochronous.socket.client;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

public class Client {
    private final static Charset CSUTF8 = Charset.forName("UTF-8");

    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
            channel.connect(new InetSocketAddress("localhost", 7878)).get();
            System.out.printf("Client at %s connection %n", channel.getLocalAddress());
            Attachment att = new Attachment();
            att.channel = channel;
            att.isReadMode = false;
            att.buffer = ByteBuffer.allocate(2048);
            att.mainThd = Thread.currentThread();
            byte[] data = "Hello".getBytes(CSUTF8);
            att.buffer.put(data);
            att.buffer.flip();
            channel.write(att.buffer, att, new ReadWriteHandler());
            try
            {
                att.mainThd.join();
            }
            catch (InterruptedException ie)
            {
                System.out.println("Client terminating");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
