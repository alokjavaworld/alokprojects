package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements IBankDAO {
	private static final String WITHDEAW_AMT="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String DEPOSIT_AMT="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";

	
	 private JdbcTemplate jt;
	 
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int withdrwal(long accno, double amt) {
	    int count =jt.update(WITHDEAW_AMT, amt,accno);
		return count;
	}

	@Override
	public int deposit(long accno, double amt) {
		  int count =jt.update(DEPOSIT_AMT, amt,accno);
			return count;
	
	}

}
