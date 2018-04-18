package com.jiangjian.study.java.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ByteFlipDemo {
    public static void main(String[] args) {
//        String[] poem = {
//                "Roses are red",
//                "Violets are blue",
//                "Sugar is sweet",
//                "And so are you"
//        };
//
//        CharBuffer buffer = CharBuffer.allocate(50);
//        for(int i = 0; i < poem.length; i++) {
//            for(int j = 0; j < poem[i].length(); j++) {
//                buffer.put(poem[i].charAt(j));
//            }
//            buffer.flip();
//            System.out.println("\n--------------------------------");
//            System.out.println("Limit: " + buffer.limit());
//            System.out.println("Capacity: " + buffer.capacity());
//            System.out.println("Position: " + buffer.position());
//            while(buffer.hasRemaining()) {
//                System.out.print(buffer.get());
//            }
//            buffer.clear();
//        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        System.out.println("Position: " + byteBuffer.position());

        byteBuffer.flip().flip();
        System.out.println("Position: " + byteBuffer.position());
        //byteBuffer.put((byte) 4); BufferOverflowException
        byteBuffer.get(); //BufferUnderflowException

    }
}
