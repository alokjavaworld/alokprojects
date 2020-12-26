package com.raj.servcie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.raj.bo.StudentBO;
import com.raj.dao.IStudentInfo;
import com.raj.dto.StudentDTO;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentInfo dao;

	@Override
	public List<StudentDTO> fetchStudent() {
		List<StudentBO> listbo = dao.getAllStudent();
		List<StudentDTO> listdto = new ArrayList();
		listbo.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			dto.setRoll(bo.getRoll());
			dto.setSname(bo.getSname());
			dto.setMobile(bo.getMobile());
			dto.setAadhar(bo.getAadhar());
			dto.setStd(bo.getStd());
			dto.setFname(bo.getFname());
			dto.setSadd(bo.getSadd());
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public StudentDTO fetchStudentByRoll(int roll) {
		StudentBO bo = null;
		StudentDTO dto=new StudentDTO();
		//invoke method
		bo=dao.getStudentByRoll(roll);
		//convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		 return dto;
	}
	
	@Override
	public String updateStudent(StudentDTO dto) {
		 StudentBO bo=new StudentBO();
		 //convert dto to bo
		 BeanUtils.copyProperties(dto, bo);
		 //invoke method
		 int count=dao.updateStudnet(bo);
		return (count==0)?bo.getRoll()+"Record Not Updated":bo.getRoll()+" Roll  Record are updated";
	}
	@Override
	public String deleteStudent(int roll) {
		int count=dao.deleteStudnet(roll);
		return (count==0)?roll+": Are Not Deleted":roll+": Roll No Are Deleted";
	} 
	
	@Override
	public String insertStudent(StudentDTO dto) {
	  StudentBO bo=new StudentBO();
	  //convert dto to bo
	  BeanUtils.copyProperties(dto, bo);
	  //invoke method
	  int count=dao.insertStudent(bo);
		return (count==0)?"Record Are Not Inserted ":"Record Are Inserted";
	}
}
