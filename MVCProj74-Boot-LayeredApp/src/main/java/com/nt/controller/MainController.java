package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.vo.EmployeeVO;

import lombok.AllArgsConstructor;

@Controller("controller")
//@Lazy
public class MainController {
	@Autowired
	private EmployeeService service;

	public List<EmployeeVO> getherEmp(String deg1, String deg2, String deg3) throws Exception {
		List<EmployeeDTO> listdto = null;
		List<EmployeeVO> listvo =  new ArrayList<>();
	
		// invoke method
		listdto = service.fecthEmp(deg1, deg2, deg3);
		// convert dto to vo
	
		/*
		 * for (EmployeeDTO dto : listdto) { vo = new EmployeeVO(); //convert Ineger to
		 * String and copy into vo vo.setSerialNo(dto.getSerialNo().toString());
		 * vo.setEmpNo(dto.getEmpNo().toString());
		 * vo.setDptNo(dto.getDptNo().toString()); vo.setSal(dto.getSal().toString());
		 * BeanUtils.copyProperties(dto, vo); //copy each obj to listvo listvo.add(vo);
		 * } // for
		 */		
		listdto.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDptNo(String.valueOf(dto.getDptNo()));
			 vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			 listvo.add(vo);
		});
		return listvo;
	}// method

}// class
