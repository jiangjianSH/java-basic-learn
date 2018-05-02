package com.jiangjian.study.java.nio.filesystem;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class WatcherDemo {
    public static void main(String[] args) {
        Path this_dir = Paths.get(".");
        System.out.println("Now watching the current directory...");
        try {
            WatchService watcher = this_dir.getFileSystem().newWatchService();
            this_dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey watchKey = watcher.take();
            List<WatchEvent<?>> events = watchKey.pollEvents();
            for(WatchEvent event : events) {
                System.out.println("Someone just created the file " + event.context().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
