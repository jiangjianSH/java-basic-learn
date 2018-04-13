package com.jiangjian.study.java.multithread.countfilelength;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentTotalFileSizeLatchDemo {
    private ExecutorService service;
    private AtomicLong total = new AtomicLong();
    private AtomicLong pendingFileVisits = new AtomicLong();
    private CountDownLatch latch = new CountDownLatch(1);

    private void updateTotalSizeOfDir(File file) {
        long fileSize = 0;

        if(file.isFile()) {
            fileSize = file.length();
        } else {
            File[] children = file.listFiles();
            if(children != null) {
                for (File child : children) {
                    if (child.isFile()) {
                        fileSize += child.length();
                    } else {
                        pendingFileVisits.incrementAndGet();
                        service.submit(() -> {
//                            try {
//                                System.out.println(child.getCanonicalPath());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                            updateTotalSizeOfDir(child);
                        });
                    }
                }
            }
        }
        total.addAndGet(fileSize);
        if(pendingFileVisits.decrementAndGet() == 0) {
            latch.countDown();
        }
    }

    private long getTotalSizeOfFile(final String fileName) {
        service = Executors.newFixedThreadPool(100);
        pendingFileVisits.incrementAndGet();
        updateTotalSizeOfDir(new File(fileName));
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
        return total.longValue();
    }

    public static void main(String[] args) {
        final long start = System.nanoTime();
        final long total = new ConcurrentTotalFileSizeLatchDemo().getTotalSizeOfFile("E:\\");
        final long end = System.nanoTime();
        System.out.println("Total size: " + total);
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }
}
