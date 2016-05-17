package com.example.juan.Trendy.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author by Juan on 5/16/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerApp {}
