package com.jiangjian.study.java.multithread;

public class SequentialPrimeFinder extends AbstractPrimerFinder {
    public static void main(String[] args) {
        new SequentialPrimeFinder().timeAndCompute(10000000);
    }

    @Override
    public long countPrimes(int number) {
        return countPrimesInRange(1, number);
    }
}
