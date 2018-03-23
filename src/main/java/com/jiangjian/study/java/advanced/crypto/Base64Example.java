package com.jiangjian.study.java.advanced.crypto;

import org.apache.commons.net.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Example {
    public static void main(String[] args) {
        String content = "jiangjian";
        jdkBase64(content);
        System.out.println();
        commonsCodecBase64(content);
        System.out.println();
        bouncyCastleBase64(content);
    }

    public static void jdkBase64(String content) {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(content.getBytes());
        System.out.println("Encode: " + encode);


        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String decode = new String(decoder.decodeBuffer(encode));
            System.out.println("decode:" + decode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void commonsCodecBase64(String content) {
        byte[] encodeBytes = Base64.encodeBase64(content.getBytes());
        String encode = new String(encodeBytes);
        System.out.println("Encode:" + encode);

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("Decode:" + new String(decodeBytes));
    }


    public static void bouncyCastleBase64(String content) {
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(content.getBytes());
        String encode = new String(encodeBytes);
        System.out.println("Encode:" + encode);

        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("Decode:" + new String(decodeBytes));
    }
}
