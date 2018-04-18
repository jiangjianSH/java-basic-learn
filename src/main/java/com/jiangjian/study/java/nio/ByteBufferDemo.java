package com.jiangjian.study.java.nio;

import org.openqa.selenium.By;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        Buffer buffer = ByteBuffer.allocate(7);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());

        System.out.println("Changing buffer limit to 5");
        buffer.limit(5);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());

        System.out.println("Change buffer position 3");
        buffer.position(3);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());

        byte[] datas = new byte[7];
        Buffer buffer1 = ByteBuffer.wrap(datas, 2, 3);
        System.out.println("Capacity: " + buffer1.capacity());
        System.out.println("Limit: " + buffer1.limit());
        System.out.println("Position: " + buffer1.position());
        System.out.println("Remaining: " + buffer1.remaining());
        byte[] bytes = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);
        buffer2 = ByteBuffer.wrap(bytes, 10, 50);
        if(buffer2.hasArray()) {
            System.out.println("Capacity: " + buffer2.capacity());
            System.out.println("Limit: " + buffer2.limit());
            System.out.println("Position: " + buffer2.position());
            System.out.println("Remaining: " + buffer2.remaining());

        }
    }
}
