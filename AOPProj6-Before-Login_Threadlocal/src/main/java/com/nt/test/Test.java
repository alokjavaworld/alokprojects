package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.Manager;
import com.nt.service.BankServiceImpl;
import com.nt.service.IBankService;

public class Test {

	public static void main(String[] args) {
      
		//create ioc contaner
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy bean
		IBankService proxy=ctx.getBean("servcie",IBankService.class);
		//get manager bean
		Manager manager = ctx.getBean("manager",Manager.class);
		
		try {
			manager.signIn("raja", "raja");
			System.out.println(proxy.withdrwal(10002, 200));
			System.out.println(proxy.deposit(10002, 200000));
			manager.logout();
		}catch (IllegalArgumentException e) {
		System.out.println(" username or password incorrect which are entered");
		}
		
		catch (Exception e) {
	    e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
