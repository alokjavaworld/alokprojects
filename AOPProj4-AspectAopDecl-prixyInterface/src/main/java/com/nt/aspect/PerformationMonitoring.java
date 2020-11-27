package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformationMonitoring{
	
	public Object monitor(ProceedingJoinPoint pjp)  throws Throwable{
		System.out.println("PerformationMonitoring.monitor() start ");
		long start =System.currentTimeMillis();
		
		Object retval=pjp.proceed();
		long end=System.currentTimeMillis();
		System.out.println("PerformationMonitoring.monitor() end");
		System.out.println(pjp.getClass().getName()+ "  with args   "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+ " ms");
		return retval;
	}
}

