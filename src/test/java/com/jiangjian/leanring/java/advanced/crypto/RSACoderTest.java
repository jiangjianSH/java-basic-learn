package com.jiangjian.leanring.java.advanced.crypto;

import com.jiangjian.study.java.advanced.crypto.RSACoder;
import org.apache.commons.net.util.Base64;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class RSACoderTest {
    private byte[] privateKey;
    private byte[] publicKey;

    @Before
    public void init() throws Exception {
        Map<String, Object> keyMap = RSACoder.intKey();
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.out.println("私钥:" + Base64.encodeBase64String(privateKey));
        publicKey = RSACoder.getPublicKey(keyMap);
        System.out.println("公钥:" + Base64.encodeBase64String(publicKey));
    }

    @Test
    public void test() throws Exception {
        String content = "eIDN6OP+WU8UAmMhOUTUAg==";

        byte[] rsaEncrypted = RSACoder.encryptByPublicKey(content.getBytes(), publicKey);
        System.out.println("公钥加密后结果:" + Base64.encodeBase64String(rsaEncrypted));

        byte[] rsaDecrypted = RSACoder.decryptByPrivateKey(rsaEncrypted, privateKey);
        System.out.println("解密后数据是:" + new String(rsaDecrypted));
    }
}
