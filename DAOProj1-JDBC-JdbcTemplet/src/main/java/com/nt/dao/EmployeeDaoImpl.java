package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements IEmployeeDao {
	private JdbcTemplate jt;
    
	private static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP" ;
	public EmployeeDaoImpl(JdbcTemplate jt) {

		this.jt = jt;
	}

	@Override
	public int coutEmp() {
		int count =0;
		count=jt.queryForObject(GET_EMP_COUNT	, Integer.class);
		return count;
	}

}
