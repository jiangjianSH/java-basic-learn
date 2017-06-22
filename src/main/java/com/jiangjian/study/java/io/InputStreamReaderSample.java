package com.jiangjian.study.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class InputStreamReaderSample {
    public static void main(String[] args) {
        try {
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
