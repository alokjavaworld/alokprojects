package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Component("voterAnno")
public class Voter  {
    @Autowired
    @Value("alokraj")
	private String name;
	private int age;
	private Date date;

	// b.method
	public String voterApp() {
		date=new Date();
		if (age > 18)
			return "Mr/Miss  " + name + " you are  eligble for voting";
		else
			return "Mr/Miss   " + name + " you are not eligble for voting";

	}

	@PreDestroy
	public void destroy() {
	System.out.println("Voter.destroy()");
		name = null;
		age = 0;

	}

	@PostConstruct
	public void afterPropertiesSet()  {
	System.out.println("Voter.afterPropertiesSet()");
		if (age == 0 && name == null)
			throw new IllegalArgumentException("invalid input");

	}

	
	/*  //life cycle method
	public void init() { System.out.println("Voter.init()");
	  if(age==0&&name==null) throw new IllegalArgumentException("invalid input"); }
	  
	  //life cycle destroyrd 
	 public void distroye() {
	  System.out.println("Voter.distroye()"); name=null; age=0; }*/
	 

}// class
