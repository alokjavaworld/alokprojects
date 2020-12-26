package com.raj.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Profile implements CommandLineRunner {
   
	@Value("${my.app.driver}")
	private String driver;
	 
	@Override
	public void run(String... args) throws Exception {
	System.out.println("DONE");
	System.out.println(driver);
	}

	
}
