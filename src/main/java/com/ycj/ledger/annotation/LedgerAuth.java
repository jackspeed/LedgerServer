package com.ycj.ledger.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2018-03-12 15:39
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LedgerAuth {

    boolean isNeed() default false;
}
