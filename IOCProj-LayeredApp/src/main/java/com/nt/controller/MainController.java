package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMngService;
import com.nt.vo.CustomerVO;

public final class MainController {
	private CustomerMngService service;

	public MainController(CustomerMngService service) {

		this.service = service;
	}

	public String processCustomer(CustomerVO vo) throws Exception {
		String result=null;
		CustomerDTO dto=null;
		//create dto obj
		dto=new CustomerDTO();
		//convert vo to dto
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setpAmt(Float.parseFloat(vo.getpAmt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		
		
		result=service.calculateSimpleIntrestAmount(dto);
		return result;
	}

}
