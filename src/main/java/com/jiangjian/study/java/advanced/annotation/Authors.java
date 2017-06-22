package com.jiangjian.study.java.advanced.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.TYPE})
public @interface Authors { Author[] value();
}
