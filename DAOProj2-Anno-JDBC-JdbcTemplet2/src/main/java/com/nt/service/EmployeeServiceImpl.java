package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	

	@Override
	public int fetchEmpCount() {

		return dao.coutEmp();
	}
}
