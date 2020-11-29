package com.nt.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.ZomatoApp;

public class Mobile {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ZomatoApp app=null;
		//cretae ioc container
		//ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//usinf ClassPathXmlApplicationContext
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
	//	app=ctx.getBean("zomato",ZomatoApp.class);
		//placed order
		/*
		 * app.order("chicken", 2); System.out.println(
		 * "----------------------------------------------------------------");
		 * app.order("momos", 5);
		 */

	}

}
