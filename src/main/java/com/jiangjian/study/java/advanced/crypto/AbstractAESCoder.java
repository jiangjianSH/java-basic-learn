package com.jiangjian.study.java.advanced.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public abstract class AbstractAESCoder {
    public static final String KEY_ALGORITHM = "AES";

    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static Key toKey(byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception  {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] initKey() throws Exception{
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(128);
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }
}
