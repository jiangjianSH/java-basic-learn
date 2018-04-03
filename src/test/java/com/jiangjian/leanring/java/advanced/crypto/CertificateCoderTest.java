package com.jiangjian.leanring.java.advanced.crypto;

import com.jiangjian.study.java.advanced.crypto.CertificateCoder;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class CertificateCoderTest {
    private String password = "123456";
    private String alias = "www.jiangjian.cn";
    private String certifactePath = "C:\\Users\\Administrator\\Desktop\\测试数据\\jiangjian.cer";
    private String keyStorePath = "C:\\Users\\Administrator\\Desktop\\测试数据\\jiangjian.keystore";

    /**
     * 公钥加密--私钥解密
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        System.out.println("公钥加密--私钥解密");
        String content = "数字证书";
        byte[] data = content.getBytes();

        //公钥加密
        byte[] encrypt = CertificateCoder.encryptByPublicKey(data, certifactePath);

        //私钥解密
        byte[] decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
        System.out.println("加密前:" + content);
        System.out.println("解密后:" + new String(decrypt));
        assertArrayEquals(data, decrypt);
    }

    /**
     * 私钥加密--公钥解密
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        System.out.println("私钥加密--公钥解密");
        String content = "数字证书1";
        byte[] data = content.getBytes();

        //私钥加密
        byte[] encrypt = CertificateCoder.encryptByPrivateKey(data, keyStorePath, alias, password);

        //公钥解密
        byte[] decrypt = CertificateCoder.decryptByPublicKey(encrypt, certifactePath);
        System.out.println("加密前:" + content);
        System.out.println("解密后:" + new String(decrypt));
        assertArrayEquals(data, decrypt);
    }

    /**
     * 测试签名
     */
    @Test
    public void test2() throws Exception {
        String content = "签名";
        byte[] data = content.getBytes();
        System.out.println("私钥签名--公钥验证");
        byte[] sign = CertificateCoder.sign(data, keyStorePath, alias, password);

        System.out.println("签名:" + Hex.toHexString(sign));

        boolean status = CertificateCoder.verify(data, sign, certifactePath);
        System.out.println("状态:" + status);
        assertTrue(status);
    }
}
