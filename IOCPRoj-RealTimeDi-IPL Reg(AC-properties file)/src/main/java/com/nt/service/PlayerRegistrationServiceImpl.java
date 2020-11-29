package com.nt.service;

import com.nt.bo.PlayerRegistrationBO;
import com.nt.dao.PlayerRegistration;
import com.nt.dto.PlayerRegistrationDTO;

public final class PlayerRegistrationServiceImpl implements PlayerRegistrationService {
	private PlayerRegistration dao;

	public PlayerRegistrationServiceImpl(PlayerRegistration dao) {

		this.dao = dao;
	}

	@Override
	public String calculateAverage(PlayerRegistrationDTO dto) throws Exception {
		float averageRun = 0.0f;
		float averageWicket = 0.0f;

		String result = null;
		int count = 0;
		PlayerRegistrationBO bo = null;

		// calculate average run

		if (dto.getTotalRun() != 0 && dto.getInnings() <= dto.getMatches()) {

			averageRun = dto.getTotalRun() / dto.getInnings();
			
		} else {
			averageRun = 0;
		}

		// calculate average wicket

		if (dto.getTotalWicket() != 0 && dto.getInnings() <= dto.getMatches()) {

			averageWicket = dto.getTotalWicket() / dto.getInnings();
			

		} // if
		else {

			averageWicket = 0;
		} // else

		// cretae bo object and sotre values
		bo = new PlayerRegistrationBO();
		bo.setpName(dto.getpName());
		bo.setAge(dto.getAge());
		bo.setCountry(dto.getCountry());
		bo.setTeam(dto.getTeam());
		bo.setMatches(dto.getMatches());
		bo.setInnings(dto.getInnings());
		bo.setTotalRun(dto.getTotalRun());
		bo.setTotalWicket(dto.getTotalWicket());
		bo.setAverageRun(averageRun);
		bo.setAverageWicket(averageWicket);
		// invoke method

		count = dao.insert(bo);
		if (count == 0) {

			return "player registration failed : paname :" + dto.getpName() + " Average Runrate :" + averageRun
					+ "Average Wicket" + averageWicket;
		} else {

			return "player registration succeded : paname :" + dto.getpName() + " Average Runrate :" + averageRun
					+ "Average Wicket" + averageWicket;
		} // else
	}// method
}
