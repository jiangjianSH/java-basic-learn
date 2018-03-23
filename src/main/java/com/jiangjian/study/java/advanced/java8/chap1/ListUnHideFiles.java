package com.jiangjian.study.java.advanced.java8.chap1;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ListUnHideFiles {
    public static void main(String[] args) throws IOException {
        File[] unhidenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isHidden();
            }
        });
        for(File unhidenFile : unhidenFiles) {
            System.out.println(unhidenFile.getCanonicalFile());
        }

        System.out.println("##############");

        File[] unhidenFiles1 = new File(".").listFiles(File::isHidden);
        for(File unhidenFile1 : unhidenFiles1) {
            System.out.println(unhidenFile1.getCanonicalFile());
        }
    }
}
