package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBo;

public interface IStudentDao {
	public StudentBo getEmpById(int id);
	public List<StudentBo> getAllStudent();
	public List<StudentBo> getStudentByCity(String city, String city2);

}
