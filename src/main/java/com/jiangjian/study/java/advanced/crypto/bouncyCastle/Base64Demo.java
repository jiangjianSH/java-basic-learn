package com.jiangjian.study.java.advanced.crypto.bouncyCastle;

import org.bouncycastle.util.encoders.Base64;

public class
Base64Demo {
    public static void main(String[] args) {
        String content = "Base64 编码";
        byte[] encodedContent = Base64.encode(content.getBytes());
        System.out.println("Encoded:" + new String(encodedContent));

        byte[] decodedContent = Base64.decode(encodedContent);
        System.out.println("Decoded:" + new String(decodedContent));



    }
}
