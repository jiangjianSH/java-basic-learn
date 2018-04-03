package com.jiangjian.study.java.advanced.crypto;

import org.apache.commons.net.util.Base64;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AESCoderTest {
    @Test
    public void test() throws Exception {
        String inptStr = " <xl>\n" +
                "                   <nameCheckResult>一致</nameCheckResult>\n" +
                "\t\t   <documentNoCheckResult>一致</documentNoCheckResult>\n" +
                "\t\t   <collegeCheckResult>一致</collegeCheckResult>\n" +
                "\t\t   <collegeLevelCheckResult>一致</collegeLevelCheckResult>\n" +
                "\t\t   <studyStyleCheckResult>一致</studyStyleCheckResult>\t\t\n" +
                "\t\t   <graduateTimeCheckResult>一致</graduateTimeCheckResult>\t\n" +
                "                   <result>不一致</result>\n" +
                "\t\t   <studyResult>毕业</studyResult>\n" +
                "                 </xl>";
        byte[] inputData = inptStr.getBytes();


        //byte[] key = AbstractAESCoder.initKey();
        byte[] key = new Base64().decode("eIDN6OP+WU8UAmMhOUTUAg==");
        System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

        inputData = AbstractAESCoder.encrypt(inputData, key);
        System.out.println("加密后:\t" + Base64.encodeBase64String(inputData));

        byte[] outputData = AbstractAESCoder.decrypt(inputData, key);
        String outputStr = new String(outputData);
        System.out.println("解密后:\t" + outputStr);

        assertEquals(inptStr, outputStr);
    }
}
