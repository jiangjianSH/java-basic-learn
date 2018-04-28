package com.jiangjian.study.java.nio.asynochronous.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ReadFileDemo {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        AsynchronousFileChannel ch = AsynchronousFileChannel.open(Paths.get("pom.xml"));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Future<Integer> result = ch.read(byteBuffer, 0);
        while(!result.isDone()) {
            System.out.println("Sleeping...");
            Thread.sleep(500);
        }
        System.out.println("Finished = " + result.isDone());
        System.out.println("Bytes read = " + result.get());
        byteBuffer.flip();
        System.out.println("Content:");
        while(byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
        ch.close();
    }
}
