package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDto;

public interface IStudentService {
 
	public StudentDto fetchEmpById(int id);
	public List<StudentDto> fetchStusentd();
	public List<StudentDto> fetchStudentByCity(String  city,String city1);
}
