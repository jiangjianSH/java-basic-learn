package com.jiangjian.study.java.io;

import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestOutputStreamDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        DigestOutputStream outputStream = new DigestOutputStream(System.out, messageDigest);
        outputStream.write(1);
        System.out.println(Hex.toHexString(outputStream.getMessageDigest().digest()));

    }
}
