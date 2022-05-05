package com.jiangjian.study.java.multithread.thread;

public class ThreadLocalHolder {
    private static final ThreadLocal<String> data = new ThreadLocal<String>();

    public static void setDBType(String dbType) {
        data.set(dbType);
    }

    public static String getDBType() {
        return data.get();
    }

    public static void clearDBType() {
        data.remove();
    }
}
