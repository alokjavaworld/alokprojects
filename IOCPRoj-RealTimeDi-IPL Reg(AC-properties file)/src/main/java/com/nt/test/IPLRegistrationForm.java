package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.bo.PlayerRegistrationBO;
import com.nt.controller.MainController;
import com.nt.vo.PlayerRegistrationVO;

public final class IPLRegistrationForm {

	public static void main(String[] args) {
		System.out.println("----IPL REGISTRATION---------");
		Scanner sc = null;
		ApplicationContext ctx  = null;
		
		MainController controller = null;
		PlayerRegistrationVO vo = null;
		String pname = null, country = null, team = null;
		String age = null, inning = null, matches = null, run = null, wicket = null;
		String result = null;
		// cretare sacnner object
		sc = new Scanner(System.in);
		// read input
		System.out.println("Enter pname");
		pname = sc.next();
		System.out.println("Enter age");
		age = sc.next();
		System.out.println("Enter country");
		country = sc.next();
		System.out.println("Enter team");
		team = sc.next();
		System.out.println("enter matches");
		matches = sc.next();
		System.out.println("enter inning");
		inning = sc.next();
		System.out.println("enter run");
		run = sc.next();
		System.out.println("enter wicket");
		wicket = sc.next();
		// create vo object
		vo = new PlayerRegistrationVO();
		// store inpute on vo object
		vo.setpName(pname);
		vo.setAge(age);
		vo.setCountry(country);
		vo.setMatches(matches);
		vo.setInnings(inning);
		vo.setTeam(team);
		vo.setTotalRun(run);
		vo.setTotalWicket(wicket);
		// create ioc container
	   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	
		// create controller obj
		controller = ctx.getBean("controller", MainController.class);

		// invoke method
		try {
			result = controller.process(vo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
     
		System.out.println(result);

	}

}
