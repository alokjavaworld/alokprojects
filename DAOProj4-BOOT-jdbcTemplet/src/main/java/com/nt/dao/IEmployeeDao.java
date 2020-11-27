package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
	
	public int countEmp();
	public String getEmpNameById(int id);
	public Map<String,Object>  getEmpDetailById(int id);
	public List<Map<String,Object>> getEmpByDesignation(String des1, String des2);
	public int insertEmp(String ename,String job, float sal);
    public int addBonus(String job,float bonus);
}
