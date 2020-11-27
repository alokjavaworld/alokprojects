package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
  
	 public Object login(ProceedingJoinPoint pjp) throws Throwable {
		 System.out.println("Entering  into "+pjp.getSignature()+ " with args "+Arrays.toString(pjp.getArgs()));
		 Object retval=pjp.proceed();
		 System.out.println("Leaving from "+pjp.getSignature()+" with args " +Arrays.toString(pjp.getArgs())); 
		 return retval;
		 
	 }
}
