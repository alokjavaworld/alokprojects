package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBo;

//@Repository("stuDao")
public class StudnetDaoImpl implements IStudentDao {
	@Autowired
	private JdbcTemplate jt;

	private static final String GET_STUDENT_BY_ID = "SELECT SNO,SNAME,SADD,AVRG FROM STUDENT WHERE SNO=?";
	private static final String GET_ALL_STUDENT="SELECT SNO,SNAME,SADD,AVRG FROM STUDENT";
	private static final String GET_ALL_STUDENT_BY_CITY="SELECT SNO,SNAME,SADD,AVRG FROM STUDENT WHERE SADD IN(?,?)"; 
	@Override
	public StudentBo getEmpById(int id) {
	  StudentBo bo=null;
	 bo=jt.queryForObject(GET_STUDENT_BY_ID, new StudentRowMapper(), id);
		return bo;
	}

//inner class for row mapper 
	private static class StudentRowMapper implements RowMapper<StudentBo> {

		@Override
		public StudentBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		       	StudentBo bo = new StudentBo();
                 bo.setSno(rs.getInt(1));
                 bo.setSname(rs.getString(2));
                 bo.setSadd(rs.getString(3));
                 bo.setAvrg(rs.getFloat(4));
		         return bo;
		}

	}


@Override
public List<StudentBo> getAllStudent() {
	List<StudentBo> listbo=null;
	listbo= jt.query(GET_ALL_STUDENT, new StudentResultsetExtractor());
	return listbo;
}


//inner cass
private static class StudentResultsetExtractor implements ResultSetExtractor<List<StudentBo>>{

	@Override
	public List<StudentBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		System.out.println("StudnetDaoImpl.StudentResultsetExtractor.extractData()");
		List<StudentBo> listbo=new ArrayList();
		while(rs.next()) {
			StudentBo bo=new StudentBo();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			bo.setAvrg(rs.getFloat(4));
			listbo.add(bo);
		}
		return listbo;
	}
	
	
}//inner class


@Override
public List<StudentBo> getStudentByCity(String city, String city2) {
	List<StudentBo> listbo=new ArrayList<>();
	jt.query(GET_ALL_STUDENT_BY_CITY, new StudentRowCallBack(listbo),city,city2);
	return listbo;
}
 
//inner class
 private static class StudentRowCallBack implements RowCallbackHandler{
   private List<StudentBo> listbo;
    
    public StudentRowCallBack(List<StudentBo> listbo) {
	this.listbo = listbo;
}

    @Override
	public void processRow(ResultSet rs) throws SQLException {
    	System.out.println("StudnetDaoImpl.StudentRowCallBack.processRow()");
	 	StudentBo bo=new StudentBo();
	 	//converts rs to bo
	 	bo.setSno(rs.getInt(1));
	 	bo.setSname(rs.getString(2));
	 	bo.setSadd(rs.getString(3));
	 	bo.setAvrg(rs.getFloat(4));
	 	listbo.add(bo);
		
	}
	
	
}//end inner class

	
}//class
