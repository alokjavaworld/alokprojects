package com.raj.dao;

import java.util.List;

import com.raj.bo.StudentBO;

public interface IStudentInfo {

	public List<StudentBO> getAllStudent();
	public StudentBO getStudentByRoll(int roll);
	public int updateStudnet(StudentBO bo);
	public int deleteStudnet(int roll);
	public int insertStudent(StudentBO bo);
}
