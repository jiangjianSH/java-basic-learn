package com.jiangjian.study.java.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class DataInputStreamSample {
    public static void main(String[] args) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
            dataOutputStream.writeInt(2);
            dataOutputStream.writeFloat(1.3f);
            dataOutputStream.flush();
            dataOutputStream.close();

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.txt"));
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readFloat());
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
