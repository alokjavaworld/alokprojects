package com.nt.controller;

import com.nt.bo.PlayerRegistrationBO;
import com.nt.dto.PlayerRegistrationDTO;
import com.nt.service.PlayerRegistrationService;
import com.nt.vo.PlayerRegistrationVO;

public final class MainController {
	private PlayerRegistrationService service;

	public MainController(PlayerRegistrationService service) {
		super();
		this.service = service;
	}

	public String process(PlayerRegistrationVO vo) throws Exception {
		PlayerRegistrationDTO dto = null;
		String result = null;
		// convert vo obje to dtp
		dto = new PlayerRegistrationDTO();
		dto.setpName(vo.getpName());
		dto.setAge(Integer.parseInt(vo.getAge()));
		dto.setCountry(vo.getCountry());
		dto.setTeam(vo.getTeam());
		dto.setMatches(Integer.parseInt(vo.getMatches()));
		dto.setInnings(Integer.parseInt(vo.getInnings()));
		dto.setTotalRun(Integer.parseInt(vo.getTotalRun()));
		dto.setTotalWicket(Integer.parseInt(vo.getTotalWicket()));
		//invoke method
		result=service.calculateAverage(dto);
		
		
		
		return result;
	}

}
