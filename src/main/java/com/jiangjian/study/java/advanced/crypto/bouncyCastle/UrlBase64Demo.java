package com.jiangjian.study.java.advanced.crypto.bouncyCastle;

import org.bouncycastle.util.encoders.UrlBase64;

public class UrlBase64Demo {
    public static void main(String[] args) {
        String content = "Base64 编码";
        byte[] encodedContent = UrlBase64.encode(content.getBytes());
        System.out.println("Encoded:" + new String(encodedContent));

        byte[] decodedContent = UrlBase64.decode(encodedContent);
        System.out.println("Decoded:" + new String(decodedContent));
    }
}
