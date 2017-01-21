package com.jiangjian.study.java.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class PipedReaderWriterSample {
    public static void main(String[] args) {
        PipedWriter pipedWriter = new PipedWriter();
        try {
            PipedReader pipedReader = new PipedReader(pipedWriter);

            Runnable t1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        pipedWriter.write("jiangjian");
                        pipedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable t2 = new Runnable() {
                @Override
                public void run() {
                    try {
                        int data = pipedReader.read();
                        while(data != -1) {
                            System.out.print((char) data);
                            data = pipedReader.read();
                        }
                        pipedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(t1).start();
            new Thread(t2).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
