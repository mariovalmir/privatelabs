package com.procergs.privatelabs.infra;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * Interceptor espec�fico da aplica��o.
 * 
 */
@AppInterceptor @Interceptor
public class AppInterceptorImpl {
	
	@Inject
	Logger log;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        final String methodName = context.getMethod().getName();
    	log.trace("Antes de executar m�todo " + methodName);
    	
    	Object result = context.proceed();
    	
    	log.trace("Depois de executar m�todo " + methodName);
    	return result;
    }
    
}