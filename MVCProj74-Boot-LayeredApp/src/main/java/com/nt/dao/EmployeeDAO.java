package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
 
	public List<EmployeeBO> getEmp(String deg1,String deg2,String deg3)throws Exception;
}
