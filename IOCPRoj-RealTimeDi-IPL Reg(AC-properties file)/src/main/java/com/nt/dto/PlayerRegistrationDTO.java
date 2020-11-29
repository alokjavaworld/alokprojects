package com.nt.dto;

import java.io.Serializable;

public class PlayerRegistrationDTO implements Serializable {
	private String pName;
	private int age;
	private String country;
	private String team;
	private int matches;
	private int innings;
	private int totalRun;
	private int totalWicket;
	
	
	//setter & getters
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getMatches() {
		return matches;
	}
	
	public void setMatches(int matches) {
		this.matches = matches;
	}
	
	public int getInnings() {
		return innings;
	}
	
	public void setInnings(int innings) {
		this.innings = innings;
	}
	
	public int getTotalRun() {
		return totalRun;
	}
	
	public void setTotalRun(int totalRun) {
		this.totalRun = totalRun;
	}
	
	public int getTotalWicket() {
		return totalWicket;
	}
	
	public void setTotalWicket(int totalWicket) {
		this.totalWicket = totalWicket;
	}
	
	
	
}
