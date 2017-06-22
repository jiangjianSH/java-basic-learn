package com.jiangjian.study.java.multithread;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
public class DeadlockSample {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        SyncTask task1 = new SyncTask(obj1, obj2);
        SyncTask task2 = new SyncTask(obj2, obj3);
        SyncTask task3 = new SyncTask(obj3, obj1);

        new Thread(task1, "t1").start();
        new Thread(task2, "t2").start();
        new Thread(task3, "t3").start();
    }
}

class SyncTask implements Runnable {
    private Object obj1;
    private Object obj2;

    public SyncTask(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + "acquired lock on " + obj1);
            work();

            System.out.println(name + "acquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + "acquired lock on " + obj2);
                work();
            }
            System.out.println(name + "released lock on " + obj2);
        }

        System.out.println(name + "released lock on " + obj1);
    }

    private void work() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
