package com.jiangjian.study.java.nio.asynochronous.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class ReadFileWithCompletionHandlerDemo {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        AsynchronousFileChannel ch = AsynchronousFileChannel.open(Paths.get("pom.xml"));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Thread mainThd = Thread.currentThread();
        System.out.println(mainThd);
        ch.read(byteBuffer, 0, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println(Thread.currentThread());
                System.out.println("Finished");
                System.out.println("Bytes read = " + result);
                byteBuffer.flip();
                System.out.println("Content:");
                while(byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                mainThd.interrupt();
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("read failed");
                mainThd.interrupt();
            }
        });

        System.out.println("waiting for completion");

        try {
            mainThd.join();
        }catch (InterruptedException e) {

        }

        ch.close();
    }
}
