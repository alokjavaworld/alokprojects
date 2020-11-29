package com.nt.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Voter {
	private String name;
	private int age;

	// b.method
	public String voterApp() {
		if (age >18)
			return "Mr/Miss  " + name + " you are  eligble for voting";
		else
		return "Mr/Miss   "  + name + " you are not eligble for voting";
			
	}// b.method
	
	
	//life cycle method
	public void init() {
		System.out.println("Voter.init()");
		if(age==0&&name==null)
			throw new IllegalArgumentException("invalid input");
	}
	
	//life cycle destroyrd
	public void distroye() {
		System.out.println("Voter.distroye()");
		name=null;
		age=0;
	}

}// class
