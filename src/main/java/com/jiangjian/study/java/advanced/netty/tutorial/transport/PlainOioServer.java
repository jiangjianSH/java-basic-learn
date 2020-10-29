package com.jiangjian.study.java.advanced.netty.tutorial.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {
    public void serve(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        for(;;) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Received connection from " + clientSocket);
            new Thread(new Runnable() {
                @Override
                public void run() {
                   OutputStream out;
                   try {
                       out = clientSocket.getOutputStream();
                       out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                       out.flush();
                       clientSocket.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainOioServer().serve(9999);
    }
}
