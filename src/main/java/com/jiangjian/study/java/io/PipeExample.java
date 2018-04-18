package com.jiangjian.study.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream, 4);

        Thread t1 =  new Thread(() -> {
            try {
                pipedOutputStream.write(1);
                System.out.println("producer: 1");

                pipedOutputStream.write(2);
                System.out.println("producer: 2");

                pipedOutputStream.write(3);
                System.out.println("producer: 3");

                pipedOutputStream.write(4);
                System.out.println("producer: 4");

                pipedOutputStream.write(5);
                System.out.println("producer: 5");

                pipedOutputStream.write(6);
                System.out.println("producer: 6");

                pipedOutputStream.write(7);
                System.out.println("producer: 7");

                pipedOutputStream.write(8);
                System.out.println("producer: 8");

                pipedOutputStream.write(9);
                System.out.println("producer: 9");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000L);
                int data = pipedInputStream.read();
                System.out.println("read: " + data);
                data = pipedInputStream.read();
                System.out.println("read: " + data);

                Thread.sleep(10000L);

                data = pipedInputStream.read();
                System.out.println("read: " + data);
                data = pipedInputStream.read();

                Thread.sleep(3000L);
                System.out.println("read: " + data);
                data = pipedInputStream.read();
                System.out.println("read: " + data);
                data = pipedInputStream.read();
                System.out.println("read: " + data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
