package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
public class MvcProj74BootLayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(MvcProj74BootLayeredAppApplication.class, args);
		List<EmployeeVO> listvo = null;
		MainController controller = null;

	
		// get bean
		
		
		controller = ctx.getBean("controller", MainController.class);

		try {
			// invoke method
			listvo = controller.getherEmp("clerk", "analyst", "salesman");

			// print each obj data
			
			/*
			 * for(EmployeeVO vo1:listvo) { System.out.println(vo1); }
			 */
			
			/*
			 * listvo.forEach(vo -> { System.out.println(vo); });
			 */
			
			listvo.forEach(vo->System.out.println(vo));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} //
			// close container

		((AbstractApplicationContext) ctx).close();
		
	}

}
