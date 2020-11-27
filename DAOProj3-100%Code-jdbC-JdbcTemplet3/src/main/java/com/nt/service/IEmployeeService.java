package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

	public int fetchEmpCount();
	public String fetchEmpNameByID(int id);
    public Map<String,Object> fetchEmpDetails(int id);
    public List<Map<String,Object>> fecthEmpByDesignation(String des1, String des2);
    public String insertEmp(String ename, String job, float sal);
    public String addBonus(String job, float bonus);
}
