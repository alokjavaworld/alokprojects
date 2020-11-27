package com.nt.beans;

public class Job {
	private String job;
	private String loc;
	private String company;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Job [job=" + job + ", loc=" + loc + ", company=" + company + "]";
	}
	
	
	

}
