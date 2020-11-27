package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBo;

//@Repository("stuDao")
public class StudnetDaoImpl3 implements IStudentDao {
	@Autowired
	private JdbcTemplate jt;

	private static final String GET_STUDENT_BY_ID = "SELECT SNO,SNAME,SADD,AVRG FROM STUDENT WHERE SNO=?";
	private static final String GET_ALL_STUDENT="SELECT SNO,SNAME,SADD,AVRG FROM STUDENT";
	 
	@Override
	public StudentBo getEmpById(int id) {
		StudentBo bo=null;
		bo=jt.queryForObject(GET_STUDENT_BY_ID, new BeanPropertyRowMapper<StudentBo>(StudentBo.class), id);
		return bo;
	}

	@Override
	public List<StudentBo> getAllStudent() {
		List<StudentBo> listbo=null;
		BeanPropertyRowMapper<StudentBo> bprm=null;
        bprm=new BeanPropertyRowMapper<StudentBo>(StudentBo.class);
           listbo=jt.query(GET_ALL_STUDENT,new RowMapperResultSetExtractor<StudentBo>(bprm));
		return listbo;
	}

	@Override
	public List<StudentBo> getStudentByCity(String city, String city2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
