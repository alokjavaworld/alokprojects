package com.raj.servcie;

import java.util.List;

import com.raj.dto.StudentDTO;

public interface IStudentService {

	public List<StudentDTO> fetchStudent();
	public StudentDTO fetchStudentByRoll(int roll);
	public String updateStudent(StudentDTO dto);
	public String deleteStudent(int roll);
	public String insertStudent(StudentDTO dto);
}
