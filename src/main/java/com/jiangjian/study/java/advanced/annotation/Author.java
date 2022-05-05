package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.TYPE})
public @interface Author {
    String author();

    String modifiedDate() default "N/A";

    int version() default 1;

    String[] receivers() default "N/A";
}
