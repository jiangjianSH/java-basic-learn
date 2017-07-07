package com.jiangjian.study.java.temp;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class DateClearTime {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime());
    }
}
