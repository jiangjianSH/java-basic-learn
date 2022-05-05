package com.jiangjian.study.java.generic.comparable;

public class Fruit implements Comparable<Fruit> {
    private String name;

    private int size;

    public Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Fruit o) {
        int nameCompareVal = this.name.compareTo(o.name);
        if (nameCompareVal != 0) {
            return nameCompareVal;
        }
        int sizeCompareVal = this.size - o.size;
        if (sizeCompareVal == 0) {
            return 0;
        }
        return sizeCompareVal > 0 ? 1 : 0;
    }
}
