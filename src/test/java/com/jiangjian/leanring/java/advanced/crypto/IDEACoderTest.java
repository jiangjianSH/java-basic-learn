package com.jiangjian.leanring.java.advanced.crypto;

import com.jiangjian.study.java.advanced.crypto.bouncyCastle.IDEACoder;
import org.apache.commons.net.util.Base64;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IDEACoderTest {
    @Test
    public void test() throws Exception {
        String inptStr = "姜健";
        byte[] inputData = inptStr.getBytes();

        byte[] key = IDEACoder.initKey();
        System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

        inputData = IDEACoder.encrypt(inputData, key);
        System.out.println("加密后:\t" + Base64.encodeBase64String(inputData));

        byte[] outputData = IDEACoder.decrypt(inputData, key);
        String outputStr = new String(outputData);
        System.out.println("解密后:\t" + outputStr);

        assertEquals(inptStr, outputStr);
    }
}
