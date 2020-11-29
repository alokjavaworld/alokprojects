package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public final class CustomerDAOImpl implements CustomerDAO {
	private DataSource ds;
	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO SPRING_CUSTOMER VALUES(CNO_SEQ1.NEXTVAL,?,?,?,?)";

	public CustomerDAOImpl(DataSource ds) {

		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		// get pool con
		con = ds.getConnection();
		// get prepare stm

		ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);

		// set value
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getCadd());
		ps.setFloat(3, bo.getpAmt());
		ps.setFloat(4, bo.getIntramt());

		// excute query
	
		count = ps.executeUpdate();

		// close conn
		ps.close();
		con.close();

		return count;
	}

}
