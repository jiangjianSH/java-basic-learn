package com.jiangjian.study.java.nio.channel;

import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelDemo {
    public static void main(String[] args) {
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel des = Channels.newChannel(System.out);
    }

    static void copy(ReadableByteChannel src, WritableByteChannel des) {

    }
}
