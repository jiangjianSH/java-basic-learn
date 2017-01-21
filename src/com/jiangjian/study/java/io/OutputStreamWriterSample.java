package com.jiangjian.study.java.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class OutputStreamWriterSample {
    public static void main(String[] args) {
        try {
            //write to file
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("a.txt.bak", true));
            outputStreamWriter.write("中国是一个历史悠久的古老国家");
            outputStreamWriter.close();

            //output the file
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("a.txt.bak"));
            int data = inputStreamReader.read();
            while(data != -1) {
                System.out.print((char)data);
                data = inputStreamReader.read();
            }
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
