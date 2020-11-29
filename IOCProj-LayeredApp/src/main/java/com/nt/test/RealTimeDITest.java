package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {
	public static void main(String[] args) {
		System.out.println("------FILE CUSTOMER DETAILS------");
		System.out.println();
		//cretae scanner obj to read client drtails
		Scanner sc=new Scanner(System.in);
		//read client details
		System.out.print("Enter Customer Name\t:");
		String cname=sc.nextLine();
		System.out.print("Enter Customer Address\t:");
		String cadd=sc.nextLine();
		System.out.print("Enter principle Amt\t:");
		String pAmt=sc.nextLine();
		System.out.print("Enter Rate\t:");
		String rate=sc.nextLine();
		System.out.print("Enter Time\t:");
		String time=sc.nextLine();
		
		
		
		//create vo obj and store input
		CustomerVO vo=new CustomerVO();
		vo.setCname(cname);
		vo.setCadd(cadd);
		vo.setpAmt(pAmt);
		vo.setRate(rate);
		vo.setTime(time);
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		MainController main=null;
		String result=null;
		factory=new DefaultListableBeanFactory();
		reader =new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		try {
		main=factory.getBean("controller" ,MainController.class);
		
		 result = main.processCustomer(vo);
		System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
