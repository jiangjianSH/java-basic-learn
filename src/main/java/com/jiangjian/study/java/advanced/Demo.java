package com.jiangjian.study.java.advanced;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Demo {
    public static void main(String[] args) throws Exception {
        Map<String, String> m = new HashMap<>();
        m.put(null, "a");
        m.put("a", null);
    }



    public static String getEncString(byte[] src, String key) throws Exception {
        return encryptModeString(src, key);
    }

    public static String getEncString(String src, String key) throws Exception {
        return src != null && src.length() != 0 ? encryptModeString(src.getBytes(), key) : null;
    }

    public static String getDesString(byte[] src, String key) throws Exception {
        return decryptModeString(src, key);
    }

    public static String getDesString(String src, String key, String encode) throws Exception {
        return decryptModeString(src.getBytes(encode), key, encode);
    }




    private static final String Algorithm = "DESede";
    private static final String PASSWORD_CRYPT_KEY = "poiuytbVMO2XJkroULzYMMvM";


    public static byte[] encryptMode(byte[] src) throws Exception {
        return encryptMode(src, "poiuytbVMO2XJkroULzYMMvM");
    }

    public static String encryptModeString(byte[] src) throws Exception {
        return Base64.encode(encryptMode(src, "poiuytbVMO2XJkroULzYMMvM"));
    }

    public static String encryptModeString(byte[] src, String key) throws Exception {
        return Base64.encode(encryptMode(src, key));
    }

    public static byte[] encryptMode(byte[] src, String key) throws Exception {
        SecretKey deskey = new SecretKeySpec(build3DesKey(key), "DESede");
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(1, deskey);
        return c1.doFinal(src);
    }

    public static byte[] decryptMode(byte[] src) throws Exception {
        return decryptMode(src, "poiuytbVMO2XJkroULzYMMvM");
    }

    public static String decryptModeString(byte[] src, String key) throws Exception {
        return new String(decryptMode(Base64.decode(src), key), "UTF-8");
    }

    public static String decryptModeString(byte[] src, String key, String encode) throws Exception {
        return new String(decryptMode(Base64.decode(src), key), encode);
    }

    public static String decryptModeString(byte[] src) throws Exception {
        return new String(decryptMode(Base64.decode(src), "poiuytbVMO2XJkroULzYMMvM"));
    }

    public static byte[] decryptMode(byte[] src, String key) throws Exception {
        SecretKey deskey = new SecretKeySpec(build3DesKey(key), "DESede");
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(2, deskey);
        return c1.doFinal(src);
    }

    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes("UTF-8");
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }

        return key;
    }
}
