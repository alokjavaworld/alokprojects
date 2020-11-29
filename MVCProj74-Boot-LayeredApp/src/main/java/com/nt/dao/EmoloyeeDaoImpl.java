package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository("empDao")
public class EmoloyeeDaoImpl implements EmployeeDAO {
	@Autowired
	private DataSource ds;
	private static final String SELECT_EMP = " SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=? OR JOB=? OR JOB=?";

	@Override
	public List<EmployeeBO> getEmp(String deg1, String deg2, String deg3) throws Exception {
		List<EmployeeBO> listbo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeBO bo = null;
		try {
			// get connection
			con = ds.getConnection();
			// PreparedStatement
			ps = con.prepareStatement(SELECT_EMP);
			// set input to param
			ps.setString(1, deg1);
			ps.setString(2, deg2);
			ps.setString(3, deg3);
			// execute query
			rs = ps.executeQuery();
			// cretae collection obj
			listbo = new ArrayList<>();
			while (rs.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDptNo(rs.getInt(5));
				listbo.add(bo);

			}
		} // try
		catch (SQLException se) { // known exception
			se.printStackTrace();
			throw se; // rethrow exeption to caller
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // rethrow exception to caller
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // inner try catch
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // inner try catch
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // inner try catch
		} // finally
	
		return listbo;
	}// method

}// class
