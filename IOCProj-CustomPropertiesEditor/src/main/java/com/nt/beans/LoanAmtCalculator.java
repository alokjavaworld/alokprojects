package com.nt.beans;

public class LoanAmtCalculator {
	private LoanAmtDetails details;

	public LoanAmtCalculator(LoanAmtDetails details) {
		this.details = details;
	}

	public float calculateAmt() {
		return  (details.getpAmt()* details.getRate()* details.getTime())/1000.0f;
	}
	
	
}
