package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

		@Override
	public int fetchEmpCount() {
      	return dao.countEmp();
	}
		
		@Override
		public String fetchEmpNameByID(int id) {
             return dao.getEmpNameById(id);
		}
		
		@Override
		public Map<String, Object> fetchEmpDetails(int id) {
			Map<String,Object> map=null;
			map=dao.getEmpDetailById(id);
			return map;
		}
		@Override
		public List<Map<String, Object>> fecthEmpByDesignation(String des1, String des2) {
			List<Map<String,Object>> list=null;
			list=dao.getEmpByDesignation(des1, des2);
			return list;
		}
		@Override
		public String insertEmp(String ename, String job, float sal) {
		 int count= dao.insertEmp(ename, job, sal);
			return count==1?"Record Inserted" : "Record not inserted";
		}
		@Override
		public String addBonus(String job, float bonus) {
		 	int count=dao.addBonus(job, bonus);
			return count==0?"Bonus Not Added":"Bonus  Added";
		}
}
