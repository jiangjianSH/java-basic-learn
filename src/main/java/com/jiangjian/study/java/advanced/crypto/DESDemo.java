package com.jiangjian.study.java.advanced.crypto;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class DESDemo {
    public static void main(String[] args) {
        String content = "jiangian";
        jdkDES(content);
        bcDES(content);
    }

    public static void jdkDES(String content) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //key 转化
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] encodeResult = cipher.doFinal(content.getBytes());
            System.out.println("DESEncode:" + Hex.toHexString(encodeResult));

            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            byte[] decodeResult = cipher.doFinal(encodeResult);
            System.out.println("DESDecode:" + new String(decodeResult));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }


    public static void bcDES(String content) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //key 转化
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] encodeResult = cipher.doFinal(content.getBytes());
            System.out.println("DESEncode:" + Hex.toHexString(encodeResult));

            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            byte[] decodeResult = cipher.doFinal(encodeResult);
            System.out.println("DESDecode:" + new String(decodeResult));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
