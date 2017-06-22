package com.jiangjian.study.java.multithread;

/**
 * Created by jiangjian on 16-9-20.
 */
public class SynchronizedMethod {

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedCounter counter = new SynchronizedCounter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程１睡眠1s");
                    Thread.sleep(1000);
                    counter.increment();
                    System.out.println("线程１结果:" + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2睡眠1s");
                    Thread.sleep(1000);
                    counter.increment();
                    System.out.println("线程2结果:" + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程3睡眠1s");
                    Thread.sleep(1000);
                    counter.decrement();
                    System.out.println("线程3结果:" + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();
        t3.start();
        System.out.println("主线程结果:" + counter.value());
        t1.join();
        t2.join();
        t3.join();
        System.out.println("主线程结果(所有线程结束):" + counter.value());
    }
}

class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
