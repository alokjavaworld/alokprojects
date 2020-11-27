package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Peson;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		Peson person=ctx.getBean("per",Peson.class);
		System.out.println(person);
	}

}
