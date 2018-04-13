package com.jiangjian.study.java.multithread.countfilelength;

import java.io.File;
import java.io.IOException;

public class TotalFileSizeSequential {
    private long getTotalSizeOfFilesInDir(final File file) throws IOException {
//        System.out.println(file.getCanonicalPath());
        if(file.isFile()) return file.length();

        final File[] children = file.listFiles();
        long total = 0;
        if(children != null) {
            for(final File child : children) {
                total += getTotalSizeOfFilesInDir(child);
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        final long start = System.nanoTime();
        final long total = new TotalFileSizeSequential().getTotalSizeOfFilesInDir(new File("C://"));
        final long end = System.nanoTime();
        System.out.println("Total size: " + total);
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }
}
