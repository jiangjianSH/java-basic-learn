package com.jiangjian.study.java.multithread.countfilelength;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentTotalFileSizeByBlockingQueueDemo {
    final BlockingQueue<Long> fileSizes = new ArrayBlockingQueue<>(500);
    private ExecutorService service;
    final AtomicLong pendingFileVisits = new AtomicLong();

    private void startExploreDir(final File file) {
        pendingFileVisits.incrementAndGet();
        service.execute(new Runnable() {
            @Override
            public void run() {
                exploreDir(file);
            }
        });

    }


    private void exploreDir(File file) {
        long fileSize = 0;
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if(file.isFile()) {
            fileSize = file.length();
        } else {
            File[] children = file.listFiles();
            if(children != null) {
                for(File child : children) {
                    if(child.isFile()) {
                        fileSize += child.length();
                    } else {
                        startExploreDir(child);
                    }
                }
            }
        }
        try {
            fileSizes.put(fileSize);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        pendingFileVisits.decrementAndGet();
    }

    private long getTotalSizeOfFile(final String fileName) throws InterruptedException {
        service = Executors.newFixedThreadPool(100);
        startExploreDir(new File(fileName));
        long totalSize = 0;
        try {
            while (pendingFileVisits.get() > 0 || fileSizes.size() > 0) {
                final long size = fileSizes.poll(10, TimeUnit.SECONDS);
                totalSize += size;
            }
        }finally {
            service.shutdown();
        }
        return totalSize;
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.nanoTime();
        final long total = new ConcurrentTotalFileSizeByBlockingQueueDemo().getTotalSizeOfFile("F:\\");
        final long end = System.nanoTime();
        System.out.println("Total size: " + total);
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }
}
