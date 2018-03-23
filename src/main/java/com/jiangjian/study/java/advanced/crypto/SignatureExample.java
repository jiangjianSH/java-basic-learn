package com.jiangjian.study.java.advanced.crypto;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class SignatureExample {
    public static void main(String[] args) throws NoSuchAlgorithmException,
            InvalidKeyException, UnsupportedEncodingException, SignatureException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256WithDSA");

        signature.initSign(keyPair.getPrivate(), secureRandom);

        byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
        signature.update(data);

        byte[] digitalSignature = signature.sign();


        Signature signature2 = Signature.getInstance("SHA256WithDSA");
        signature2.initVerify(keyPair.getPublic());

        signature2.update(data);

        boolean verified = signature2.verify(digitalSignature);

        System.out.println("verified = " + verified);


    }
}
