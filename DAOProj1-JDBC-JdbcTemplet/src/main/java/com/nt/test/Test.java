package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IEmployeeService;

public class Test {
	public static void main(String[] args) {
     ApplicationContext ctx=null;
     IEmployeeService service=null;
     //create ioc container
     ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
     //get bean
     service=ctx.getBean("service",IEmployeeService.class);
     //invoke method
     System.out.println("Total row : "+service.fetchEmpCount());
	
	
	}
}
