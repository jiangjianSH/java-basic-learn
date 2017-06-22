package com.jiangjian.study.java.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int i = 1;
        try(
                ServerSocket serverSocket = new ServerSocket(5000);
            )
        {
            while(true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spanwing:" + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
