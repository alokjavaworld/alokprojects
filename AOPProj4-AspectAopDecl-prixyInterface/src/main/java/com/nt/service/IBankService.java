package com.nt.service;

public interface IBankService {
	public float calculateSimpleIntrest(float pamt, float rate, float time);
	public float calculateCompoundIntrest(float pamt, float rate , float time);
}
