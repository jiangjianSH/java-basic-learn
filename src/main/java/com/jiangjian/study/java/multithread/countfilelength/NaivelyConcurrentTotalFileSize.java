package com.jiangjian.study.java.multithread.countfilelength;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NaivelyConcurrentTotalFileSize {
    private long getTotalSizeOfFilesInDir(final ExecutorService service, final File file) throws ExecutionException, InterruptedException, TimeoutException, IOException {
        if(file.isFile()) return file.length();
        long total = 0;
        final File[] children = file.listFiles();
        if(children != null) {
            List<Future<Long>> partialTotalFutures = new ArrayList<>();
            for(final File child : children) {
                partialTotalFutures.add(service.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return getTotalSizeOfFilesInDir(service, child);
                    }
                }));
            }
            for(final Future<Long> partialTotalFuture : partialTotalFutures) {
                total += partialTotalFuture.get(100, TimeUnit.SECONDS);
            }
        }
        return total;
    }

    private long getTotalFileSizeOfFile(final String fileName) {
        final ExecutorService service = Executors.newFixedThreadPool(100);
        try {
            return getTotalSizeOfFilesInDir(service, new File(fileName));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        return 0L;
    }

    public static void main(String[] args) {
        final long start = System.nanoTime();
        final long total = new NaivelyConcurrentTotalFileSize().getTotalFileSizeOfFile("E:\\");
        final long end = System.nanoTime();
        System.out.println("Total size: " + total);
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }
}
