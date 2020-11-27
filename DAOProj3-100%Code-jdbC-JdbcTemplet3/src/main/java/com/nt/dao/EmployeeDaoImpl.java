package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private JdbcTemplate jt;
    
	private static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP" ;
	private static final String GET_EMP_BY_ID="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_ALL_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESIGNATION="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE  JOB IN(?,?)";
	private static final String INSERT_EMP="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL)VALUES(EMP_SEQ.NEXTVAL,?,?,?)";
	private  static final String  ADD_BONUS_EMP_BY_DESG="UPDATE EMP SET SAL=SAL+? WHERE JOB=?";

	@Override
	public int countEmp() {
		int count =0;
		count=jt.queryForObject(GET_EMP_COUNT	, Integer.class);
		return count;
	}
	
	
	
	@Override
	public String getEmpNameById(int id) {
	String result=jt.queryForObject(GET_EMP_BY_ID, String.class,id);
		return result;
	}

	@Override
	public Map<String, Object> getEmpDetailById(int id) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_ALL_EMP_BY_ID, id);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmpByDesignation(String des1, String des2) {
		 List<Map<String,Object>> list=null;
		 list=jt.queryForList(GET_EMP_BY_DESIGNATION	, des1,des2);
		 return list;
	}
	@Override
	public int insertEmp(String ename, String job, float sal) {
	  int count =jt.update(INSERT_EMP, ename,job,sal);
		return count;
	}
	@Override
	public int addBonus(String job, float bonus) {
		int count =jt.update(ADD_BONUS_EMP_BY_DESG, bonus,job);
		return count;
	}
	
}
