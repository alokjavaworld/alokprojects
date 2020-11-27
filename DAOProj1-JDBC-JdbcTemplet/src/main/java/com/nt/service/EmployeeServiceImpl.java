package com.nt.service;

import com.nt.dao.IEmployeeDao;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao dao;

	public EmployeeServiceImpl(IEmployeeDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int fetchEmpCount() {

		return dao.coutEmp();
	}
}
