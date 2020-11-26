package com.nt.service;

public interface IBankService {
 
	public String withdrwal(long accno, double amt);
	public String deposit(long accno, double amt);
}
