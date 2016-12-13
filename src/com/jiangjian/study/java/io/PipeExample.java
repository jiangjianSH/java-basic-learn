package com.jiangjian.study.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pipedOutputStream.write("Hello world".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = pipedInputStream.read();
                    while(data != -1) {
                        System.out.println((char)data);
                        data = pipedInputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
