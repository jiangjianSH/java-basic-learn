package com.jiangjian.study.java.advanced.crypto;

import org.apache.commons.net.util.Base64;
import org.bouncycastle.util.encoders.Hex;

import java.io.FileInputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class KeyStoreDemo {
    private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception{
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream is = new FileInputStream(keyStorePath);
        ks.load(is, password.toCharArray());
        is.close();
        return ks;
    }

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = getKeyStore("C:\\Users\\Administrator\\Desktop\\测试数据\\jiangjian.keystore", "123456");

        String alias = "www.jiangjian.cn";

        Key key = keyStore.getKey(alias, "123456".toCharArray());
        if(key instanceof PrivateKey) {
            Certificate cert = keyStore.getCertificate(alias);
            System.out.println(cert.getType());
            X509Certificate x509Certificate = (X509Certificate) cert;
            System.out.println("签名算法:\n" + x509Certificate.getSigAlgName());
            System.out.println("签名:\n" + Hex.toHexString(x509Certificate.getSignature()));
            System.out.println("RSA公钥:\n" + Hex.toHexString(x509Certificate.getPublicKey().getEncoded()));
            System.out.println("序列号:" + Hex.toHexString(x509Certificate.getSerialNumber().toByteArray()));
            System.out.println("颁发者:" + x509Certificate.getIssuerDN());

            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate);
            PublicKey publicKey = cert.getPublicKey();
            new KeyPair(publicKey, (PrivateKey) key);
        }
    }
}
