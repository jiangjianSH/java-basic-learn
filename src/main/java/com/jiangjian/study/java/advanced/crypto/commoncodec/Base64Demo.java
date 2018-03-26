package com.jiangjian.study.java.advanced.crypto.commoncodec;

import org.apache.commons.codec.binary.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        String content = "Base64 编码";
        Base64 base64 = new Base64();
        byte[] encodedContent = base64.encode(content.getBytes());
        System.out.println("Encoded:" + new String(encodedContent));

        byte[] decodedContent = base64.decode(encodedContent);
        System.out.println("Decoded:" + new String(decodedContent));

    }
}
