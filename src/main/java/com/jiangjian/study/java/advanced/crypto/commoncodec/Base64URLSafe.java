package com.jiangjian.study.java.advanced.crypto.commoncodec;

import org.apache.commons.net.util.Base64;

public class Base64URLSafe {
    public static void main(String[] args) {
        String content = "Base64 编码";
        byte[] encodedContent = Base64.encodeBase64URLSafe(content.getBytes());
        System.out.println("Encode:" + new String(encodedContent));

        byte[] decodedContent = Base64.decodeBase64(encodedContent);
        System.out.println("Decode:" + new String(decodedContent));
    }
}
