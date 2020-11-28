package com.nt.service;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ShoppingStore {
    
	 public float generateBill(String[] items, float[] prices) {
		 boolean problem=false;
		 System.out.println(Arrays.toString(items));
		 System.out.println(Arrays.toString(prices));
		 if(items==null || prices==null) 
			  problem=true;
			for(float p:prices)  {
				if(p<=0.0f) {
					System.out.println("ShoppingStore.generateBill()");
					problem = true;
					break;
				}//if
			}//for
			 
			if(problem) {
				throw new IllegalArgumentException("invalid inputs");
			}
		  
			 float billAmt =0.0f;
			 for(float p:prices) {
				 billAmt+=p;
			 }
		 
			 return billAmt;
		 
		 
 }	//method
  
}//class
