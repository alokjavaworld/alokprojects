package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("per")
@ConfigurationProperties(prefix = "per.info")

public class Peson {
	private int pno;
	private String pname;
	@Value("${com.padd}")
	private String padd;
	private int marks[];
	private List<Integer> marks1;
	private Set<Integer> marks2;
	private Map<String,Object> skill;
	private Job job; //composition
	
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPadd() {
		return padd;
	}
	public void setPadd(String padd) {
		this.padd = padd;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public List<Integer> getMarks1() {
		return marks1;
	}
	public void setMarks1(List<Integer> marks1) {
		this.marks1 = marks1;
	}
	public Set<Integer> getMarks2() {
		return marks2;
	}
	public void setMarks2(Set<Integer> marks2) {
		this.marks2 = marks2;
	}
	public Map<String, Object> getSkill() {
		return skill;
	}
	public void setSkill(Map<String, Object> skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Peson [pno=" + pno + ", pname=" + pname + ", padd=" + padd + ", marks=" + Arrays.toString(marks)
				+ ", marks1=" + marks1 + ", marks2=" + marks2 + ", skill=" + skill + ", job=" + job + "]";
	}
	
	
	
	
	
	
}
