package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserBO;

public class AuthenticationDAOImpl implements AuthenticationDAO {
   private static final String CHECKCREDENTIAL="SELECT COUNT(*) FROM USER_LIST WHERE USERNAME=? AND PASSWORD=?";
   
   private JdbcTemplate jt;
   
	public AuthenticationDAOImpl(JdbcTemplate jt) {
	this.jt = jt;
}


	@Override
	public int checkCradential(UserBO bo) {
        int count =jt.queryForObject(CHECKCREDENTIAL	, Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}

}
