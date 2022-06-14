package com.banking;

import java.util.Scanner;

public class Banking {
	
	OTPGenerator otpGenerator;
	
	public Banking() {
		// TODO Auto-generated constructor stub
	}

	public Banking(OTPGenerator otpGenerator) {
		super();
		this.otpGenerator = otpGenerator;
	}

	public double withdraw(double amount, Customer customer)
	{
		double balance = customer.getBalance();
		if(balance >= amount)
		{
			balance -= amount;
			customer.setBalance(balance);
		}
		else {
			System.out.println("Cannot withdraw");
		}
		return balance;
	}
	public double deposit(double amount, Customer customer)
	{
		double balance = customer.getBalance();
		balance+= amount;
		customer.setBalance(balance);
		return balance;
	}
	public void transfer(Customer from, Customer to, double amount)
	{
		int gotp = otpGenerator.generateOtp();
		System.out.println("Please enter the otp to transfer money "+gotp);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sent otp, it will expire in 30 seconds");
		int otp = sc.nextInt();
		if(gotp == otp)
		{
			double balance = from.getBalance();
			if(balance >= amount)
			{
				balance -= amount;
				from.setBalance(balance);
				double tobal = to.getBalance();
				tobal+=amount;
				to.setBalance(balance);
			}
			else {
				System.out.println("Cannot Transfer, no balance");
			}
		}
		else
			System.out.println("OTP incorrect , transfer cannot be done");
		//sc.close();
	}
}
