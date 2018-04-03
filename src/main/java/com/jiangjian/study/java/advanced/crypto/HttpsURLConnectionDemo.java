package com.jiangjian.study.java.advanced.crypto;

import javax.net.ssl.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

public class HttpsURLConnectionDemo {
    public static final String PROTOCOL = "TLS";

    private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream is = new FileInputStream(keyStorePath);
        keyStore.load(is, password.toCharArray());
        is.close();
        return keyStore;
    }

    private static SSLSocketFactory getSSLSocketFactory(String password, String keyStorePath, String trustStorePath) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        KeyStore keyStore = getKeyStore(keyStorePath, password);

        keyManagerFactory.init(keyStore, password.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore trustStore = getKeyStore(trustStorePath, password);
        trustManagerFactory.init(trustStore);


        SSLContext ctx = SSLContext.getInstance(PROTOCOL);

        ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        return ctx.getSocketFactory();
    }

    public static void configSSLSocketFactory(HttpsURLConnection conn, String password, String keyStorePath, String trustKeyStorePath) throws Exception {
        SSLSocketFactory sslSocketFactory = getSSLSocketFactory(password, keyStorePath, trustKeyStorePath);
        conn.setSSLSocketFactory(sslSocketFactory);
    }

    public static void main(String[] args) throws Exception {
        testBaidu();

    }

    public static void testCustom() throws Exception {
        String password = "123456";
        String keyStorePath = "C:\\Users\\Administrator\\Desktop\\测试数据\\jiangjian.keystore";
        String trustKeyStorePath = "C:\\Users\\Administrator\\Desktop\\测试数据\\jiangjian1.keystore";
        String httpsUrl = "https://www.jiangjianedu.cn:8443/demo/index.jsp";
        URL url = new URL(httpsUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        configSSLSocketFactory(conn, password, keyStorePath, trustKeyStorePath);
        int length = conn.getContentLength();
        byte[] data = null;
//        if (length != -1) {
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        data = new byte[length];
        dis.readFully(data);
        dis.close();
        System.err.println(new String(data));
//        }
        conn.disconnect();

    }


    public static void testBaidu() throws Exception {
        String httpsUrl = "https://www.baidu.com/index.html";
        URL url = new URL(httpsUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        int length = conn.getContentLength();
        byte[] data = null;
        if (length != -1) {
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            data = new byte[length];
            dis.readFully(data);
            dis.close();
            System.err.println(new String(data));
        }
        conn.disconnect();
    }
}
