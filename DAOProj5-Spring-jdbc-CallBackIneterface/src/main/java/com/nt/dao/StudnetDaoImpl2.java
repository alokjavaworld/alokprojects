package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBo;

@Repository("stuDao")
public class StudnetDaoImpl2 implements IStudentDao {
	@Autowired
	private JdbcTemplate jt;

	private static final String GET_STUDENT_BY_ID = "SELECT SNO,SNAME,SADD,AVRG FROM STUDENT WHERE SNO=?";
	private static final String GET_ALL_STUDENT="SELECT SNO,SNAME,SADD,AVRG FROM STUDENT";
	private static final String GET_ALL_STUDENT_BY_CITY="SELECT SNO,SNAME,SADD,AVRG FROM STUDENT WHERE SADD IN(?,?)"; 
	@Override
	public StudentBo getEmpById(int id) {
		StudentBo bo=null;
		bo=jt.queryForObject(GET_STUDENT_BY_ID, (rs,rowNum)->{
			StudentBo bo1 = new StudentBo();
            bo1.setSno(rs.getInt(1));
            bo1.setSname(rs.getString(2));
            bo1.setSadd(rs.getString(3));
            bo1.setAvrg(rs.getFloat(4));
	         return bo1;
	     	}, id);
		return bo;
	}

	@Override
	public List<StudentBo> getAllStudent() {
		List<StudentBo> listbo1=jt.query(GET_ALL_STUDENT, //args1
				                                                          //lamda expression
				                                                       rs->{
			                                                             List<StudentBo> listbo=new ArrayList<>();
			                                                                while(rs.next()) {
			                                                                	StudentBo  bo=new StudentBo();
						                                                    	  bo.setSno(rs.getInt(1));
						                                                    	  bo.setSname(rs.getString(2));
						                                                    	  bo.setSadd(rs.getString(3));
						                                                    	  bo.setAvrg(rs.getFloat(4));
						                                                    	  listbo.add(bo);
			                                                                }//end while
		                                                               return listbo;
		                                                               }//end lamda
				                                                    );//end param
		return listbo1;
	}//method

	@Override
	public List<StudentBo> getStudentByCity(String city, String city2) {
		List<StudentBo> listbo=new ArrayList();
		jt.query(GET_ALL_STUDENT_BY_CITY,//args1
				       rs->{
				    	   System.out.println("StudnetDaoImpl2.getStudentByCity() lamda");
				    	   StudentBo bo=new StudentBo();
				    	   //converts rs to bo
				    	   bo.setSno(rs.getInt(1));
				    	   bo.setSname(rs.getString(2));
				    	   bo.setSadd(rs.getString(3));
				    	  bo.setAvrg(rs.getFloat(4));
				    	  //add bo to listbo
				    	  listbo.add(bo);
				       },//args2
				       city,city2);
		return listbo;
	}//end
	

}//class
