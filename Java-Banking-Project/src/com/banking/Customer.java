package com.banking;

public class Customer {

	private String accno;
	private String password;
	private double balance;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	
	public Customer(String accno, String password, double balance) {
		super();
		this.accno = accno;
		this.password = password;
		this.balance = balance;
	}


	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
