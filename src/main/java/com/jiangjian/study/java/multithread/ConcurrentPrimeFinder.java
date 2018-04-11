package com.jiangjian.study.java.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentPrimeFinder extends AbstractPrimerFinder {
    private final int poolSize;
    private final int numberOfParts;

    public ConcurrentPrimeFinder(int poolSize, int numberOfParts) {
        this.poolSize = poolSize;
        this.numberOfParts = numberOfParts;
    }

    public static void main(String[] args) {
        new ConcurrentPrimeFinder(8, 15).timeAndCompute(10000000);
    }

    @Override
    public long countPrimes(int number) {
        int count = 0;
        final List<Callable<Integer>> partitions = new ArrayList<>();
        final int chuncksPerPartition = number / numberOfParts;
        for(int i = 0; i < numberOfParts; i++) {
            final int lower = (i * chuncksPerPartition) + 1;
            final int upper = (i == numberOfParts - 1) ? number : lower + chuncksPerPartition -1;
            partitions.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return countPrimesInRange(lower, upper);
                }
            });
        }

        final ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        try {
            final List<Future<Integer>> results = executorService.invokeAll(partitions, 10000, TimeUnit.SECONDS);
            executorService.shutdown();
            for(final Future<Integer> result : results) {
                count += result.get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return count;
    }
}
