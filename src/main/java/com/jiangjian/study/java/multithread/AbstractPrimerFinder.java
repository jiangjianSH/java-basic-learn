package com.jiangjian.study.java.multithread;

public abstract class AbstractPrimerFinder {
    public boolean isPrimer(final int number) {
        if(number <= 1)  {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }

        }
        return true;
    }

    public int countPrimesInRange(final int lower, final int upper) {
        int total = 0;
        for(int i = lower; i <= upper; i++) {
            if(isPrimer(i)) {
                total++;
            }
        }
        return total;
    }

    public void timeAndCompute(final int number) {
        final long start = System.nanoTime();
        final long numberOfPrimes = countPrimes(number);
        final long end = System.nanoTime();
        System.out.println("number is :" + numberOfPrimes);
        System.out.println("time spend:" + (end -start)/1.0e9);
    }

    public abstract long countPrimes(int number);
}
