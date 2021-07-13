package com.jiangjian.study.java.advanced.annotation.inherited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Inherited
public @interface InheritedAnnotationType {
}
