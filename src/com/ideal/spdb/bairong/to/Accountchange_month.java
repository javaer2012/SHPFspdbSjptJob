package com.ideal.spdb.bairong.to;

public class Accountchange_month {
	private Accountchange_month_creditcard creditcard;
	private Accountchange_month_debitcard debitcard;
	private String loan;
	public Accountchange_month_creditcard getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(Accountchange_month_creditcard creditcard) {
		this.creditcard = creditcard;
	}
	public Accountchange_month_debitcard getDebitcard() {
		return debitcard;
	}
	public void setDebitcard(Accountchange_month_debitcard debitcard) {
		this.debitcard = debitcard;
	}
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	
}
