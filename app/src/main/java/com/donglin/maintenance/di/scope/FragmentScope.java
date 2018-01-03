package com.donglin.maintenance.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author yoosir
 *         Created by Administrator on 2016/12/23 0023.
 * @version 1.0
 */


@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
