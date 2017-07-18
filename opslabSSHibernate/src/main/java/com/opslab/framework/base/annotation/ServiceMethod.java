package com.opslab.framework.base.annotation;

import java.lang.annotation.*;


@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ServiceMethod {
	public ServiceType type() default ServiceType.BUSINESS;
	public String value() default "业务方法";
}
