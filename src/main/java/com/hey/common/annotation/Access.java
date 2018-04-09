package com.hey.common.annotation;

import java.lang.annotation.*;

/**
 * Created by heer on 2018/3/29.
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Access {
    String[] value() default {};

    String[] roles() default {};

    String[] authorities() default {};
}
