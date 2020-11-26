package com.nt.dao;

public interface IBankDAO {
 
	public int withdrwal(long accno, double amt); 
	public int deposit(long accno, double amt); 

}
