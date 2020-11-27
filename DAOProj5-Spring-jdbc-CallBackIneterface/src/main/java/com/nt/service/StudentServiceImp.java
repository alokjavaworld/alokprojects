package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBo;
import com.nt.dao.IStudentDao;
import com.nt.dto.StudentDto;

@Service("service")
public class StudentServiceImp implements IStudentService {
	@Autowired
	private IStudentDao dao;

	@Override
	public StudentDto fetchEmpById(int id) {
		StudentBo bo = null;
		StudentDto dto = new StudentDto();
		// invoke method
		bo =dao.getEmpById(id);
		// converts bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDto> fetchStusentd() {
 		List<StudentDto> listdto=new ArrayList();
 		List<StudentBo> listbo=null;
 		//invoke method
 		listbo=dao.getAllStudent();
 		//converts bo to dto
 		listbo.forEach(bo->{
 			StudentDto dto =new StudentDto();
 			BeanUtils.copyProperties(bo, dto);
 		     listdto.add(dto);
 		});
 		
 		return listdto;
	}

	@Override
	public List<StudentDto> fetchStudentByCity(String city, String city1) {
	List<StudentDto> listdto=new ArrayList<>();
	List<StudentBo> listbo=dao.getStudentByCity(city, city1);
	//converts bo to dto
	listbo.forEach(bo->{
		StudentDto dto=new StudentDto();
		BeanUtils.copyProperties(bo, dto);
		listdto.add(dto);
	});
 		return listdto;
	}
}
