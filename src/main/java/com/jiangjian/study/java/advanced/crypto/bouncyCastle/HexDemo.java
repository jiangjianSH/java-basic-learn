package com.jiangjian.study.java.advanced.crypto.bouncyCastle;

import org.bouncycastle.util.encoders.Hex;

public class HexDemo {
    public static void main(String[] args) {
        String str = "Hex 编码";
        System.out.println("原文:\t" + str);
        byte[] input = str.getBytes();

        //Hex 编码
        byte[] data = Hex.encode(input);
        System.out.println("编码后：\t" + new String(data));

        byte[] output = Hex.decode(data);
        System.out.println("解码后:\t" + new String(output));
    }
}
