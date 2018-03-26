package com.jiangjian.study.java.advanced.crypto.commoncodec;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Demo {
    public static void main(String[] args) {
        String input = "MD5消息摘要";
        System.out.println("原文:" + input);
        String md5Hex = DigestUtils.md5Hex(input);
        System.out.println(md5Hex);
    }
}
