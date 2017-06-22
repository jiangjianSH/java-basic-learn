package com.jiangjian.study.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public class SocketTest {
    public static void main(String[] args){
        try(
                Socket socket = new Socket();
        )
        {
            socket.connect(new InetSocketAddress("localhost", 3000), 2000);
            System.out.println("###isConnect:" + socket.isConnected());
            InputStream input = socket.getInputStream();
            Scanner in = new Scanner(input);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

