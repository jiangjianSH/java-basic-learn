package com.jiangjian.study.java.advanced.crypto.bouncyCastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class BounceCastleLoading {
    public static void main(String[] args) {
        Provider bounceCastleProvider = new BouncyCastleProvider();
        Security.addProvider(bounceCastleProvider);

        Provider provider = Security.getProvider("BC");
        System.out.println(provider == bounceCastleProvider);

        System.out.println(provider);

        for(Map.Entry<Object, Object> entry: provider.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() );
        }
    }
}
