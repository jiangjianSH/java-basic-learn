package com.jiangjian.leanring.java.advanced.crypto;

import com.jiangjian.study.java.advanced.crypto.AbstractAESCoder;
import org.apache.commons.net.util.Base64;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AESCoderTest {
    @Test
    public void test() throws Exception {
        String inptStr = "姜健";
        byte[] inputData = inptStr.getBytes();

        byte[] key = AbstractAESCoder.initKey();
        System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

        inputData = AbstractAESCoder.encrypt(inputData, key);
        System.out.println("加密后:\t" + Base64.encodeBase64String(inputData));

        byte[] outputData = AbstractAESCoder.decrypt(inputData, key);
        String outputStr = new String(outputData);
        System.out.println("解密后:\t" + outputStr);

        assertEquals(inptStr, outputStr);
    }
}
