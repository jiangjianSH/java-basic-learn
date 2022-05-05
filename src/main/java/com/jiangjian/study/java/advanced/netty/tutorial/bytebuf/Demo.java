package com.jiangjian.study.java.advanced.netty.tutorial.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class Demo {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in action rocks!", utf8);

        ByteBuf copy = buf.copy();
        copy.setByte(0, (byte)'J');
        System.out.println(copy.toString(utf8));
        System.out.println(buf.toString(utf8));

        ByteBuf sliced = buf.slice(0, 14);
        System.out.println(sliced.toString(utf8));
        buf.setByte(0, (byte)'J');
        System.out.println(sliced.toString(utf8));

        System.out.println(ByteBufUtil.hexDump(copy));
    }
}
