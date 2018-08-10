package com.jiangjian.study.java.advanced.jvm.basic.exception;

public class Pitcher {
    private static Ball ball = new Ball();

    static void playBall() {
        int i = 0;
        for (;;) {
            try {
                if (i % 4 == 3) {
                    throw ball;
                }
                ++i;
            }
            catch (Ball b) {
                i = 0;
            }
        }
    }
}
