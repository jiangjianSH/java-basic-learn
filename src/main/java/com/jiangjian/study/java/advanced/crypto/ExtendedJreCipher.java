package com.jiangjian.study.java.advanced.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class ExtendedJreCipher {
    public static void main(String[] args) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256);
            SecretKey secretKey = kg.generateKey();
            byte[] key = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
