package com.jiangjian.study.java.datastruction.list;

/**
 * Created by Administrator on 2016/11/17 0017.
 */
public interface  List<T> {

    boolean add(T t);

    boolean remove(T t);

    boolean insert(T t);

    boolean insert(T t, int index);

}
