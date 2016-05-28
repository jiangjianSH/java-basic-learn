package com.jiangjian.study.java.generic;

/**
 * Created by Administrator on 2016/5/28.
 */
public class Pair<T, U> {
    private T first;
    private U second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
