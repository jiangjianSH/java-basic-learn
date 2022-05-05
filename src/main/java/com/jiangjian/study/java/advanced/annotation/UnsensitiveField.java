package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.FIELD})
public @interface UnsensitiveField {
    String category();
}
