package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private JdbcTemplate jt;
    
	private static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP" ;
	

	@Override
	public int coutEmp() {
		int count =0;
		count=jt.queryForObject(GET_EMP_COUNT	, Integer.class);
		return count;
	}

}
