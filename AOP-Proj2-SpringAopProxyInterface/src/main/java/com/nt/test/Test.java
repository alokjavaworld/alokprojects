package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
import com.nt.service.BankServiceImpl;

public class Test {
	public static void main(String[] args) {
    ApplicationContext ctx=null;
    BankService proxy=null;
    //create ioc container
    ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    //get proxy objetx
    proxy=ctx.getBean("proxy",BankService.class);
    //inovke the method
    System.out.println("intrest are "+proxy.calculateSimpleIntrest(10000, 2, 1));
    
    
    //close the container
    ((AbstractApplicationContext) ctx).close();
	}
}
