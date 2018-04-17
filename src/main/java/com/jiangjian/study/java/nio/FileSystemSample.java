package com.jiangjian.study.java.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by jiangjian on 2017/6/22.
 */
public class FileSystemSample {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("tempt.txt");
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write("我就是姜健");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
