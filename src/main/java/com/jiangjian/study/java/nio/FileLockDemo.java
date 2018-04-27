package com.jiangjian.study.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

public class FileLockDemo {
    final static int MAXQUERYIES = 150000;
    final static int MAXUPDATES = 150000;

    final static int RECLEN = 16;

    static ByteBuffer buffer = ByteBuffer.allocate(RECLEN);
    static IntBuffer intBuffer = buffer.asIntBuffer();

    static int counter = 1;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean writer = sc.nextBoolean();

        RandomAccessFile raf = new RandomAccessFile("filelocl.tmp", (writer) ? "rw" : "r");
        FileChannel fileChannel = raf.getChannel();
        
        if(writer) {
            update(fileChannel);
        } else {
            query(fileChannel);
        }
    }

    private static void query(FileChannel fileChannel) throws IOException {
        for(int i = 0; i < MAXQUERYIES; i++) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("acquiring shared lock");
            FileLock lock = fileChannel.lock(0, RECLEN, true);
            try {
                buffer.clear();
                fileChannel.read(buffer, 0);
                int a = intBuffer.get(0);
                int b = intBuffer.get(1);
                int c = intBuffer.get(2);
                int d = intBuffer.get(3);
                System.out.println("Reading: " + a + " " +
                        b + " " +
                        c + " " +
                        d);
                if (a * 2 != b || a * 3 != c || a * 4 != d) {
                    System.out.println("error");
                    return;
                }
            }finally {
                lock.release();
            }
        }
    }

    private static void update(FileChannel fileChannel) throws IOException {
        for(int i = 0; i < MAXUPDATES; i++) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("acquiring exclusivie lock");
            FileLock lock = fileChannel.lock(0, RECLEN, false);
            try {
                intBuffer.clear();
                fileChannel.read(buffer, 0);
                int a = counter;
                int b = a * 2;
                int c = a * 3;
                int d = a * 4;
                System.out.println("Writing: " + a + " " +
                        b + " " +
                        c + " " +
                        d);
                intBuffer.put(a);
                intBuffer.put(b);
                intBuffer.put(c);
                intBuffer.put(d);
                counter++;
                buffer.clear();
                fileChannel.write(buffer, 0);
            }finally {
                lock.release();
            }
        }
    }
}
