package com.nt.dto;


public class StudentDto {
	private int sno;
	private String sname;
	private String sadd;
	private Float avrg;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public Float getAvrg() {
		return avrg;
	}
	public void setAvrg(Float avrg) {
		this.avrg = avrg;
	}
	@Override
	public String toString() {
		return "StudentDto [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avrg=" + avrg + "]";
	}

	
}
