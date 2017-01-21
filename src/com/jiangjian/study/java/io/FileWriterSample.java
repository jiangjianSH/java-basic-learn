package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class FileWriterSample {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("a.txt.bak", true);
            fileWriter.write("\njiangjian\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
