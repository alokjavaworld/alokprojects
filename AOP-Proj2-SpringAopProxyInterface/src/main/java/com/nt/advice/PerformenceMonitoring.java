package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformenceMonitoring  implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformenceMonitoring.invoke()");
		long start =System.currentTimeMillis();
		Object retVal = invocation.proceed();
		long end = System.currentTimeMillis();
		System.out.println(invocation.getClass().getName()+" with args"+Arrays.toString(invocation.getArguments())+"has taken"+(end-start)+"ms");
		return retVal;
	}

}
