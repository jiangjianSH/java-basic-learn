package com.jiangjian.study.java.advanced.spring.ioc;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Mountain {
    private long altitude;

    public Mountain(long altitude) {
        this.altitude = altitude;
    }

    public long getAltitude() {
        return altitude;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "altitude=" + altitude +
                '}';
    }
}
