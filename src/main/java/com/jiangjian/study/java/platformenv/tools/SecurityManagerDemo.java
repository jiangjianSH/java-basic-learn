package com.jiangjian.study.java.platformenv.tools;

public class SecurityManagerDemo {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println("securityManager == " + securityManager);
    }
}
