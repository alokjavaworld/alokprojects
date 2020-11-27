package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IEmployeeService;

@SpringBootApplication
public class DaoProj4BootJdbcTempletApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IEmployeeService service=null;
		ctx=SpringApplication.run(DaoProj4BootJdbcTempletApplication.class, args);
	     service=ctx.getBean("service",IEmployeeService.class);
	     System.out.println("EMP COUNT : "+service.fetchEmpCount());
	}

}
