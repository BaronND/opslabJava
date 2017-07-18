package com.opslab.blog.admin.annotation;

/**
 * @author 0opslab
 * @descript 用户action层的方法主键
 */
import java.lang.annotation.*;


@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ActionInfo {
    public String value();
    public String url() default "";
}
