package com.raj.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raj.bo.StudentBO;



@Repository
public class StudentInfoImpl implements IStudentInfo {
	private static final String GET_ALL_STUDENT="SELECT ROLL,NAME,SADD,MOBILE,CLASS,FNAME,AADHAR  FROM STUDENT_INFO";
    private static final String GET_STUDENT_BY_ROLL="SELECT ROLL,NAME,SADD,MOBILE,CLASS,FNAME,AADHAR FROM STUDENT_INFO WHERE ROLL=?";
    private static final String UPDATE_STUDENT="UPDATE STUDENT_INFO SET NAME=?,SADD=?,MOBILE=?,CLASS=? ,FNAME=?,AADHAR=?  WHERE ROLL=?";
   private static final String DELETE_STUDENT="DELETE FROM STUDENT_INFO WHERE ROLL=?";
   private static final String INSERT_STUDENT=" INSERT INTO STUDENT_INFO (ROLL,NAME,SADD,MOBILE,CLASS,FNAME,AADHAR)VALUES(STU_SEQ.NEXTVAL,?,?,?,?,?,?)";
   @Autowired
	private JdbcTemplate jt;

	@Override
	public List<StudentBO> getAllStudent() {
		List<StudentBO> listbo1=jt.query(GET_ALL_STUDENT, //args1
				                                                          //lamda expression
				                                                       rs->{
			                                                             List<StudentBO> listbo=new ArrayList<>();
			                                                                while(rs.next()) {
			                                                                	StudentBO bo=new StudentBO();
			                                                                	bo.setRoll(rs.getInt(1));
			                                                                	bo.setSname(rs.getString(2));
			                                                                	bo.setSadd(rs.getString(3));
			                                                                	bo.setMobile(rs.getLong(4));
			                                                                	bo.setStd(rs.getString(5));
			                                                                	bo.setFname(rs.getString(6));
			                                                                	bo.setAadhar(rs.getLong(7));
						                                                    	listbo.add(bo);
			                                                                }//end while
		                                                               return listbo;
		                                                               }//end lamda
				          );//end param
		
		return listbo1;
	}//method
	
	
	@Override
	public StudentBO getStudentByRoll(int roll) {
	     StudentBO bo=null;
	     bo=jt.queryForObject(GET_STUDENT_BY_ROLL, (rs,rowNum)->{
				StudentBO bo1 = new StudentBO();
	              bo1.setRoll(rs.getInt(1));
	              bo1.setSname(rs.getString(2));
	              bo1.setSadd(rs.getString(3));
	              bo1.setMobile(rs.getLong(4));
	              bo1.setStd(rs.getString(5));
	              bo1.setFname(rs.getString(6));
	              bo1.setAadhar(rs.getLong(7));
		         return bo1;
		     	}, roll);
		return bo;
	}

	@Override
	public int updateStudnet(StudentBO bo) {
		int count=jt.update(UPDATE_STUDENT,  bo.getSname()
				                                                              ,bo.getSadd()
				                                                              ,bo.getMobile()
				                                                              ,bo.getStd()
				                                                              ,bo.getFname()
				                                                              ,bo.getAadhar()
				                                                              ,bo.getRoll()
				                                                              );
		return count;
	}
	
	@Override
	public int deleteStudnet(int roll) {
		int count=jt.update(DELETE_STUDENT, roll);
		return count;
	}
	
	
	@Override
	public int insertStudent(StudentBO bo) {
	  int count=jt.update(INSERT_STUDENT, bo.getSname(),
			                                                             bo.getSadd(),
			                                                             bo.getMobile(),
			                                                             bo.getStd(),
			                                                             bo.getFname(),
			                                                             bo.getAadhar());
		return count;
	}
}
