package com.nt.advice;

import org.aspectj.lang.JoinPoint;

public class ThrowAdvce {
   
	public void exceptionLogger(JoinPoint pj,Exception ex) {
		System.out.println(ex+" exception raised in "+ pj.getSignature());
	}
}
