package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class Test {
 
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
	   
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		proxy=ctx.getBean("shopping",ShoppingStore.class);
		//invoke method
		System.out.println(proxy.generateBill(new String[] {"shirt" ,"jeans","shoes" }, 
				                                                                      new float[] {2,300,500}));
	     
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
