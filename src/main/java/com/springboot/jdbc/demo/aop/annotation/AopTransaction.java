package com.springboot.jdbc.demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopTransaction {
    String name() default "事务名称";
    String functionName() default "方法名称";
    String className() default "类名称";
}
