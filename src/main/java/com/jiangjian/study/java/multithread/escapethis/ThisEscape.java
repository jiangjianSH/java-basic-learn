package com.jiangjian.study.java.multithread.escapethis;

public class ThisEscape {
    private int value;

    public ThisEscape(EventSource source) {
        //这种方式不可取，因为this可以在EventListener访问到，
        source.registerListener(
                new EventListener() {
                    public void onEvent(Event e) {
                        value = 10;
                    }
                });
    }
}