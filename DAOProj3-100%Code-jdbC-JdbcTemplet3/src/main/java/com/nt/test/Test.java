package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IEmployeeService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IEmployeeService service = null;
		// create ioc container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// get bean
		service = ctx.getBean("service", IEmployeeService.class);
		// invoke method
		System.out.println("Total row : " + service.fetchEmpCount());
		String s="-";
		System.out.println(s.repeat(100));
        System.out.println("Emp Name : "+service.fetchEmpNameByID(7369));
        System.out.println(s.repeat(100));
        System.out.println("EmpDetail : "+service.fetchEmpDetails(7369));
        System.out.println(s.repeat(100));
		/*
		 * List<Map<String,Object>> list=service.fecthEmpByDesignation(" CLERK" ,
		 * "SALESMAN"); for (Map<String, Object> map : list) { System.out.println(list);
		 * } list.forEach(System.out::println);
		 */
        service.fecthEmpByDesignation(" CLERK" , "SALESMAN").forEach(System.out::println);
        System.out.println(s.repeat(100));
        System.out.println(service.insertEmp("ALOK", "Dev", 9850.0f));
        System.out.println(s.repeat(100));
        System.out.println(service.addBonus("CLERK", 1000.0f));
	}
}
