package com.nt.service;

public class BankService {

	 //simple Intrest
	public float calculateSimpleIntrest(float pamt, float rate, float time) {
      System.out.println("BankService.calculateSimpleIntrest()");
		return pamt * rate * time / 100.0f;
	}
	
	public float calculateCompoundIntrest(float pamt, float rate , float time) {
		System.out.println("BankService.calculateCompoundIntrest()");
		return  ((float) (pamt*Math.pow(1, rate/time))-pamt);
	}
	
	
}
