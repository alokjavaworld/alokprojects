package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmoloyeeDaoImpl;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.zaxxer.hikari.HikariDataSource;

import lombok.AllArgsConstructor;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fecthEmp(String deg1, String deg2, String deg3) throws Exception {
		List<EmployeeBO> listbo = null;
		List<EmployeeDTO> listdto = new ArrayList<EmployeeDTO>();;
		
		// conver input to uppercase
		deg1 = deg1.toUpperCase();
		deg2 = deg2.toUpperCase();
		deg3 = deg3.toUpperCase();

		// invoke mrthod
		System.out.println("EmployeeServiceImpl.fecthEmp()");
		listbo = dao.getEmp(deg1, deg2, deg3);
		// convert bo to dto
	
		/*
		 * for (EmployeeBO bo : listbo) { edto = new EmployeeDTO();
		 * BeanUtils.copyProperties(bo, edto); edto.setSal(Math.round(bo.getSal()));
		 * edto.setSerialNo(listdto.size()+1); // copy each dto listdto.add(edto); }
		 */
		listbo.forEach(bo->{
			EmployeeDTO edto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, edto);
			edto.setSal(Math.round(bo.getSal()));
			edto.setSerialNo(listdto.size()+1);
			listdto.add(edto);
		});

		return listdto;
	}// method

}
