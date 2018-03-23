package com.jiangjian.study.java.advanced.crypto;

import javax.crypto.*;
import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CipherExample {
    public static void main(String[] args) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Cipher cipher = Cipher.getInstance("AES");
        Key key = null;
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        key = keyGenerator.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] data1 = "jiangjian".getBytes("UTF-8");
        messageDigest.update(data1);

        byte[] data2 = "fangjuan".getBytes("UTF-8");
        messageDigest.update(data2);
        byte[] messageDigestContent = messageDigest.digest();
        cipher.update(data1);
        byte[] encrpyted = cipher.doFinal(data2);

        System.out.println(new String(encrpyted));
        Cipher cipher1 = Cipher.getInstance("AES");
        cipher1.init(Cipher.DECRYPT_MODE,key);
        byte[] decrypted = cipher1.doFinal(encrpyted);
        byte[] receivedMessageDigestContent = messageDigest.digest(decrypted);
        System.out.println(Arrays.equals(messageDigestContent, receivedMessageDigestContent));
        System.out.println(new String(decrypted, "UTF-8"));
    }
}
