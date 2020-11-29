package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO>  fecthEmp(String deg1,String deg2, String deg3)throws Exception;
}
