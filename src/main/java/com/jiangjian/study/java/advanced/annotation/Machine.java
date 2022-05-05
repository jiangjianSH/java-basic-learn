package com.jiangjian.study.java.advanced.annotation;

import java.util.List;

public class Machine {
    private List versions;

    @SuppressWarnings("unchecked")
    public void addVersion(String version) {
        versions.add(version);
    }

    public static void main(String[] args) {
        new Machine();
    }
}