package com.opslab.workflow.framework.annotation;

import java.lang.annotation.*;


@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ActionMethod {
	public ActionType type() default ActionType.BUSINESS;
	public String value() default "业务请求";
}
