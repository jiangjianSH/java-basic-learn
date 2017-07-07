package com.jiangjian.study.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket i) {
        incoming = i;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("Hello! Enter BYE to exit.");

            boolean done = false;
            while(!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                System.out.println(line);
                if(line.trim().equals("BYB")) done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
