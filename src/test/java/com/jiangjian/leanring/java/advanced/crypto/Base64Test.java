package com.jiangjian.leanring.java.advanced.crypto;

import org.junit.Test;

import java.util.Base64;

public class Base64Test {
    @Test
    public void test() {
        String content = "MIIDPDCCAiSgAwIBAgIEVWQdAzANBgkqhkiG9w0BAQUFADBgMQswCQYDVQQGEwJDTjERMA8GA1UE\n" +
                "CBMIU2hhbmdoYWkxETAPBgNVBAcTCFNoYW5naGFpMQ0wCwYDVQQKEwRud2pyMQ0wCwYDVQQLEwRu\n" +
                "d2pyMQ0wCwYDVQQDEwRud2pyMB4XDTE1MDUyNjA3MTMwN1oXDTE4MDUyNTA3MTMwN1owYDELMAkG\n" +
                "A1UEBhMCQ04xETAPBgNVBAgTCFNoYW5naGFpMREwDwYDVQQHEwhTaGFuZ2hhaTENMAsGA1UEChME\n" +
                "bndqcjENMAsGA1UECxMEbndqcjENMAsGA1UEAxMEbndqcjCCASIwDQYJKoZIhvcNAQEBBQADggEP\n" +
                "ADCCAQoCggEBAKHsT60pBbW7zYgA+ppE4aQyCK7GgJ1trQzytdEEMloSWI4FvHw5eKP61BblHSu/\n" +
                "NM7tl4jqGGYJDszEEtJztINDSJ+2twGGsglE+DhcI3XpylhWr9N9kKNGZvF3L+8Y17UroAwMUUrX\n" +
                "KhI7knIcOiivt7rcWu+crFd+lHTFG9HIbta8k6hFen4tCcpekqpoJY1p9lduHBYaZJu757ACXnI4\n" +
                "Pgkn6ovUBmicaB5eRVm3pPjrB7kzgFiNctnHzvE7bwLY1KAYpJpK50S6ZiCkpcgXreIEaKihuNdl\n" +
                "qQsA9Su9cnihCa9XHns/GoVRJvHaGyAPEctLg6zRM5hcgqmrrJkCAwEAATANBgkqhkiG9w0BAQUF\n" +
                "AAOCAQEAdq6TC5ZtrcknQtIfLWAqy7VTMxmSsdRN9FdaYT6vmGr182XS9ZhzQ/40kOOKkXxHPQoT\n" +
                "SmTmbwh9AbBNAUGKq7Vy+y8VFFzSSwK+sw7L2rw/Lby/03cHVu+k0NfKkHz9wCCBE2JAUXQBByQG\n" +
                "R12cHi7zJkVG+xCEFcW1P3glMhYg3vhIwH0v+3isrndHMNfG+/Kte0dRuJjpX2uZmtap2gCrpW4R\n" +
                "GZ6I4hJIJj9U+3cqH888a7LFSN3IuLRDZ/FB7fPM6q3sLvbT9MQxs7ta1t9d0Rv6bpTnssu8hhkP\n" +
                "3DDdmfhdUvR2bftZRlNww8OICwNzaU9W226LEU9bFCmpkQ==";

        System.out.println(new String(org.bouncycastle.util.encoders.Base64.decode(content)));
    }
}
