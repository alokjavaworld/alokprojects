package com.nt.service;

public  final class  BankServiceImpl implements BankService{

	public final float calculateSimpleIntrest(float pAmt, float intest, float time) {
		System.out.println("BankService.calculateSimpleIntrest()");
		return pAmt*intest*time/100.0f;
	}

}
