package com.jiangjian.study.java.advanced.crypto;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateCoder {
    public static final String CERT_TYPE = "X.509";

    /**
     * 通过keystore获取私钥
     * @param keyStorePath
     * @param password
     * @param alias
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKeyByKeyStore(String keyStorePath, String password, String alias) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(keyStorePath), password.toCharArray());
        return (PrivateKey) keyStore.getKey(alias, password.toCharArray());
    }


    /**
     * 通过数字证书获取公钥
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKeyByKeyStore(String certificatePath) throws Exception{
        Certificate certificate = getCertificate(certificatePath);
        return certificate.getPublicKey();
    }

    /**
     * 获取keystore
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(keyStorePath), password.toCharArray());
        return keyStore;
    }

    /**
     * 通过keystore获取证书
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String keyStorePath, String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        return ks.getCertificate(alias);
    }

    /**
     * 通过证书文件直接读取证书
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String certificatePath) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance(CERT_TYPE);
        FileInputStream in = new FileInputStream(certificatePath);
        Certificate certificate = certificateFactory.generateCertificate(in);
        in.close();
        return certificate;
    }


    /**
     * 私钥加密
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String keyStorePath, String alias, String password) throws Exception {
        PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, password, alias);
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String keyStorePath, String alias, String password) throws Exception {
        PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, password, alias);
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String certificatePath) throws Exception {
        PublicKey publicKey = getPublicKeyByKeyStore(certificatePath);
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String certificatePath) throws Exception {
        PublicKey publicKey = getPublicKeyByKeyStore(certificatePath);
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }


    /**
     * 签名数据
     * @param sign
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] sign(byte[] sign, String keyStorePath, String alias, String password) throws Exception {
        X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath,alias, password);
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
        PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, password, alias);
        signature.initSign(privateKey);
        signature.update(sign);
        return signature.sign();
    }

    /**
     * 验证签名
     * @param data
     * @param sign
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, byte[] sign, String certificatePath) throws Exception{
        X509Certificate x509Certificate = (X509Certificate) getCertificate(certificatePath);
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
        signature.initVerify(x509Certificate.getPublicKey());
        signature.update(data);
        return signature.verify(sign);
    }
}
