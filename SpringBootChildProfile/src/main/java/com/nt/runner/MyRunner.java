package com.nt.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prodDb")
public class MyRunner implements CommandLineRunner{
	
	@Value("${my.app.driver}")
	private String driver;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyRunner.run()");
		System.out.println("Value is : "+driver);	
	}

}
