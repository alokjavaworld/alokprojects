package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Voter;

public class LifeCycleTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Voter vote =null,vote1=null;
		String result=null;
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		vote=ctx.getBean("voterAnno",Voter.class);
	//	vote1=ctx.getBean("voter1",Voter.class);
		// result= vote.voterApp();
		// System.out.println(result);
		 result= vote.voterApp();
	     System.out.println(result);
		System.out.println(vote);
		//close container
		((AbstractApplicationContext) ctx).close();
		
  	}//main
}//class
