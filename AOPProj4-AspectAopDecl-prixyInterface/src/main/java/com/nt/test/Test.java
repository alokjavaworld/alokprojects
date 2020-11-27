package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
import com.nt.service.IBankService;

public class Test {
	public static void main(String[] args) {
       
	ApplicationContext ctx=null;
	IBankService proxy=null;
	//crate ioc container
	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	//get bean
	proxy =ctx.getBean("bankService",IBankService.class);
	//invole method
	String s="-";
   System.out.println(proxy.calculateSimpleIntrest(80200, 25, 2));
   System.out.println(s.repeat(200));
   System.out.println(proxy.calculateSimpleIntrest(80200, 25, 2));
   System.out.println(s.repeat(200));
   System.out.println(proxy.getClass().getSuperclass());
  // System.out.println(proxy.calculateCompoundIntrest(80200, 25, 2));	
 
   //System.out.println(proxy.calculateCompoundIntrest(80200, 25, 2));
	}	
}
