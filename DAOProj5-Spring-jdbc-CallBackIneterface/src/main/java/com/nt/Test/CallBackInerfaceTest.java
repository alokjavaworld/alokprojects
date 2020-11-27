package com.nt.Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentDto;
import com.nt.service.IStudentService;

public class CallBackInerfaceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IStudentService service=null;
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		service=ctx.getBean("service",IStudentService.class);
		//invoke method
		try {
			System.out.println(service.fetchEmpById(25));
			List<StudentDto> listdto=service.fetchStusentd();
			System.out.println("-----------------------------------------------------------------------------------------------");
			listdto.forEach(System.out::println);
			System.out.println("-----------------------------------------------------------------------------------------------");
			List<StudentDto> listdto1=service.fetchStudentByCity("DD", "HYD");
			listdto1.forEach(System.out::println);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
	}//main
}//class
