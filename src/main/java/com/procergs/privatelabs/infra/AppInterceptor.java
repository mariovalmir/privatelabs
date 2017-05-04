package com.procergs.privatelabs.infra;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

import com.procergs.arqjava4.exception.ExceptionHandlerInterceptor;
import com.procergs.arqjava4.security.SegurancaInterceptor;

@Inherited
@InterceptorBinding
@SegurancaInterceptor
@ExceptionHandlerInterceptor
@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface AppInterceptor {

}
