package com.jiangjian.study.java.multithread;

public class RaceCondition {
    private static boolean done;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while(!done) {
                i++;
            }
            System.out.println("Done" + i);
        }).start();

        System.out.println("OS:" + System.getProperty("os.name"));
        Thread.sleep(2000L);
        done = true;
        System.out.println("flag done set to true");
    }
}
