package com.nt.vo;

import lombok.Data;

@Data
public class EmployeeVO {
	private String serialNo;
	private String empNo;
	private  String empName;
	private String job;
	private String sal;
	private String dptNo;
	@Override
	public String toString() {
		return "Employee Details   [serialNo=" + serialNo + ", empNo=" + empNo + ", empName=" + empName + ", job=" + job
				+ ", sal=" + sal + ", dptNo=" + dptNo + "]";
	}
	
	
}
