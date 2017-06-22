package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/2/9 0009.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
    int version();
    String date() default "N/A";
}
