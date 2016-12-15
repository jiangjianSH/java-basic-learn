package com.jiangjian.study.java.net;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class DatagramServer {
    private static BufferedReader in = null;
    private static boolean moreQuotes = true;

    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = null;
        socket = new DatagramSocket(4445);
        try {
            in = new BufferedReader(new FileReader("./src/com/jiangjian/study/java/net/quotas.txt"));
            while (moreQuotes) {
                try {
                    byte[] buf = new byte[256];

                    // receive request
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);

                    // figure out response
                    String dString = null;
                    if (in == null)
                        dString = new Date().toString();
                    else
                        dString = getNextQuote();

                    buf = dString.getBytes();

                    // send the response to the client at "address" and "port"
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    packet = new DatagramPacket(buf, buf.length, address, port);
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                    moreQuotes = false;
                }
            }
            socket.close();
        } catch (FileNotFoundException e) {
            System.err.println("Could not open quote file. Serving time instead.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static String getNextQuote() {
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "No more quotes. Goodbye.";
            }
        } catch (IOException e) {
            returnValue = "IOException occurred in server.";
        }
        return returnValue;
    }
}
