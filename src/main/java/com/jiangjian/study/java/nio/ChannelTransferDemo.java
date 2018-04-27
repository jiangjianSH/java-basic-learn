package com.jiangjian.study.java.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransferDemo {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            FileChannel inChannel = fis.getChannel();
            WritableByteChannel outChannel = Channels.newChannel(System.out);
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
    }
}
