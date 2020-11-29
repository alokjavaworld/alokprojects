package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public final class CustomerMngServiceImpl implements CustomerMngService {
	private CustomerDAO dao;

	public CustomerMngServiceImpl(CustomerDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String calculateSimpleIntrestAmount(CustomerDTO dto) throws Exception {
		float intam = 0.0f;
		CustomerBO bo = null;
		int count = 0;
		// calculate simpleintrest
		intam = (dto.getpAmt() * dto.getRate() * dto.getTime() / 100.0f);
		// create bo object having persistable data
		bo = new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setpAmt(dto.getpAmt());
		bo.setIntramt(intam);
		// insert using DAO;

		count = dao.insert(bo);
       
		if (count == 0)
			return "customer registration  failed ::Amt:: " + dto.getpAmt()+"intrest ::"+intam;
		else
			return "customer registration  Succeded ::Amt::" + dto.getpAmt()+"intrest ::"+intam;

	}

}
