package com.jiangjian.study.java.multithread.sharevariablity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EngerySource {
    private final long MAX_LEVEL =100;
    private long level = MAX_LEVEL;
    private static final ScheduledExecutorService replenshTimer = Executors.newScheduledThreadPool(10);
    private ScheduledFuture<?> replenishTask;
    private ReentrantReadWriteLock monitor = new ReentrantReadWriteLock();

    private EngerySource() {

    }

    private void init() {
        replenishTask = replenshTimer.scheduleAtFixedRate(() -> replenish(), 0, 1, TimeUnit.SECONDS);
    }

    public static EngerySource create() {
        final EngerySource engerySource = new EngerySource();
        engerySource.init();
        return engerySource;
    }


    public static void shutdown() {
        replenshTimer.shutdown();
    }

    public long getUnitsAvailable() {
        monitor.readLock().lock();
        try {
            return level;
        }finally {
            monitor.readLock().unlock();
        }
    }

    public boolean useEnergy(final long units) {
        monitor.readLock().lock();
        try {
            if (units > 0 && level >= units) {
                level -= units;
                return true;
            }
            return false;
        }finally {
            monitor.readLock().unlock();
        }
    }

    public synchronized void stopEnergySource() {
        replenishTask.cancel(false);
    }


    public void replenish() {
        monitor.writeLock().lock();
        try {
            if (level < MAX_LEVEL) {
                System.out.println("充一格点");
                level++;
            }
        }finally {
            monitor.writeLock().unlock();
        }
    }
}
