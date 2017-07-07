package com.jiangjian.study.java.multithread;

public class CalcPI1 {
    public static void main(String[] args) {
        MyThread1 t = new MyThread1();
        t.start();
        while(t.isAlive()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println ("pi = " + t.pi);
    }
}

class MyThread1 extends Thread {
    boolean negative = true;
    double pi; // Initializes to 0.0, by default
    public void run ()
    {
        for (int i = 3; i < 1000000000; i += 2)
        {
            if (negative)
                pi -= (1.0 / i);
            else
                pi += (1.0 / i);
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println ("Finished calculating PI");
    }
}
