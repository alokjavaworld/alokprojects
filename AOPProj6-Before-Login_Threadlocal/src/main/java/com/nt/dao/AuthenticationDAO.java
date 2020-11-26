package com.nt.dao;

import com.nt.bo.UserBO;

public interface AuthenticationDAO {

	public int checkCradential(UserBO bo);
}
