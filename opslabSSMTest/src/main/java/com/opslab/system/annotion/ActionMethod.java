package com.opslab.system.annotion;

import java.lang.annotation.*;

/**
 * 业务层发注解,凡是业务层的方法都必须使用该注解，否则不会执行
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ActionMethod {
    /**
     * 业务层方法的类型
     */
    public String type() default "SYSTEM::CALL";

    /**
     * 具体的业务方法说明
     */
    public String name() default "";
}
