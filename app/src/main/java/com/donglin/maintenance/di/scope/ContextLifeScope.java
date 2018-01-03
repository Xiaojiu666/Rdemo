package com.donglin.maintenance.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author yoosir
 *         Created by Administrator on 2016/12/23 0023.
 * @version 1.0
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ContextLifeScope {

    String value() default "Application";

}
