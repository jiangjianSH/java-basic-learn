package com.jiangjian.study.java.advanced.crypto;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        System.out.println(keyGenerator.generateKey().getEncoded().length);
    }
}
