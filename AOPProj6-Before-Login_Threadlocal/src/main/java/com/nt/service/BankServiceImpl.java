package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {
	private IBankDAO dao;
	

	public BankServiceImpl(IBankDAO dao) {
			this.dao = dao;
	}

	@Override
	public String withdrwal(long accno, double amt) {
		int count=dao.withdrwal(accno, amt);
		return count==0?"Withdrwal failed":"Wihtdrwal Successful from account :"+accno + " amt is "+amt;
	}

	@Override
	public String deposit(long accno, double amt) {
		int count=dao.deposit(accno, amt);
		return count==0?"deposit failed":"deposit Successful from account :"+accno + " amt is "+amt;
	}

}
