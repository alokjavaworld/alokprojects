package com.nt.manager;

import org.springframework.beans.BeanUtils;

import com.nt.bo.UserBO;
import com.nt.dao.AuthenticationDAO;
import com.nt.dto.UserDTO;

public class Manager {
 
private ThreadLocal<UserDTO> threadLocal=new ThreadLocal();
private AuthenticationDAO dao;


   public Manager( AuthenticationDAO dao) {
	this.dao = dao;
}
public void signIn(String username,String password) {
	   //set username or password
	   //convert to bo
	   UserDTO dto=new UserDTO();
	   dto.setUsername(username);dto.setPassword(password);
	   threadLocal.set(dto);
	   
	}
   public Boolean validate() {
	   //get current thread data
       UserDTO dto=threadLocal.get();
       //convert dto to bo
       UserBO bo=new UserBO();
       BeanUtils.copyProperties(dto, bo);
       //invoke mathod
       int count=dao.checkCradential(bo);
       return count==0?false:true;
   }
   
   public void logout() {
	   threadLocal.remove();
   }
}
