package com.jiangjian.study.java.generic.basic;

public class OrderPair <K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public K getKey() {
        return key;
    }

    public static void main(String[] args) {
        OrderPair orderPair;
        orderPair = new OrderPair("jiangjian", "jx");
        System.out.println(orderPair.getKey());
    }
}
