package com.nt.aop;







import org.aspectj.lang.JoinPoint;

import com.nt.manager.Manager;

public class SecurityCheck {
   private Manager manager;
   
   public SecurityCheck(Manager manager) {
      this.manager = manager;
     }

	public void check(JoinPoint jp) {
		 
		 if(!manager.validate()) {
			 throw new IllegalArgumentException("bad cradential");
		 }
		 
	 }
	
}
