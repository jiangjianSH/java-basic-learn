package com.jiangjian.study.java.multithread.countfilelength;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentTotalFileSize {
    class SubDirectoriesAndSize {
        final public long size;
        final public List<File> subDirectories;

        public SubDirectoriesAndSize(long size, List<File> subDirectories) {
            this.size = size;
            this.subDirectories = subDirectories;
        }
    }

    private SubDirectoriesAndSize getTotalAndSubDirs(final File file) {
        long total = 0;
        final List<File> subDirectories = new ArrayList<>();
        if(file.isDirectory()) {
            final File[] children = file.listFiles();
            if (children != null) {
                for(final File child : children) {
                    if(child.isDirectory()) {
                        subDirectories.add(child);
                    } else {
                        total += child.length();
                    }
                }
            }
        }
        return new SubDirectoriesAndSize(total, subDirectories);
    }

    private long getTotalSizeOfFilesInDir(final File file) {
        final ExecutorService service = Executors.newFixedThreadPool(100);

        long total = 0;
        List<File> directories = new ArrayList<>();
        directories.add(file);
        try {
            while (!directories.isEmpty()) {
                List<Future<SubDirectoriesAndSize>> partialResults = new ArrayList<>();
                for (final File directory : directories) {
                    partialResults.add(service.submit(() -> getTotalAndSubDirs(directory)));
                }
                directories.clear();
                for (final Future<SubDirectoriesAndSize> subDirectoriesAndSizeFuture : partialResults) {
                    SubDirectoriesAndSize subDirectoriesAndSize = subDirectoriesAndSizeFuture.get(100, TimeUnit.SECONDS);
                    directories.addAll(subDirectoriesAndSize.subDirectories);
                    total += subDirectoriesAndSize.size;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
        return total;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        final long start = System.nanoTime();
        final long total = new ConcurrentTotalFileSize().getTotalSizeOfFilesInDir(new File("F:\\"));
        final long end = System.nanoTime();
        System.out.println("Total size: " + total);
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }

}
