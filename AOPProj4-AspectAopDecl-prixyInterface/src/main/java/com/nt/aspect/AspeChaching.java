package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspeChaching {
	private Map<String,Object> map=new HashMap();
	
	public Object caching(ProceedingJoinPoint jpj) throws Throwable {
		String key= jpj.getSignature()+Arrays.toString(jpj.getArgs());
        Object retval=null;
		if(!map.containsKey(key)) {
			retval=jpj.proceed();
			map.put(key, retval);
		}else {
			retval=map.get(key);
			System.out.println("from cache");
		}
		return retval;
		
		
		
	}

}
