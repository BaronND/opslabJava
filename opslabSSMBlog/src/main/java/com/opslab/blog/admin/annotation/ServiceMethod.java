package com.opslab.blog.admin.annotation;

import java.lang.annotation.*;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
@Target(value= ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ServiceMethod {
    public String value();
}
