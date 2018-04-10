package com.hey.common.annotation;

import java.lang.annotation.*;

/**
 * Created by heer on 2018/4/10.
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {

    String[] value() default {};
}
