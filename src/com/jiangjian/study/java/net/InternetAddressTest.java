package com.jiangjian.study.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            for(InetAddress address : addresses) {
                display(address);
            }

            InetAddress localHostAddress = InetAddress.getLocalHost();
            display(localHostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void display(InetAddress address) {
        System.out.println("Host address: " + address.getHostAddress());
        System.out.println("Address: " + address.getHostName());
        //System.out.println("Canonical Hostname: " + address.getCanonicalHostName());
    }
}
