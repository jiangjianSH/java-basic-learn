package com.jiangjian.study.java.datastruction.adt;

public interface List<T> {
    int size();

    boolean add(T t);

    boolean add(int index, T t);

    boolean remove(int index);

    T get(int index);

    boolean set(int index, T t);

}
