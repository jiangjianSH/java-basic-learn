package com.jiangjian.study.java.datastruction.adt;

/**
 * @author jiangjian
 * @param <T>
 */
public interface Set <T> {
    /**
     * return size of set
     * @return
     */
    int size();

    /**
     * add t to set, return true if not exist, otherwise return false if already exists
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     * if t in set, remove t from set and return t to caller method
     * @param t
     * @return
     */
    T remove(T t);

    /**
     * if t in set, return t value, otherwise return null
     * @param t
     * @return
     */
    T find(T t);
}
