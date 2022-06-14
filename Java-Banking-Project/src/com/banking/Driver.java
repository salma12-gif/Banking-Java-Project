package com.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("A001", "shalini", 10000));
		customers.add(new Customer("A002", "avinash", 15000));
		customers.add(new Customer("A003", "rishita", 20000));
		
		System.out.println("Please enter the account number and the password");
		Scanner sc = new Scanner(System.in);
		String accno = sc.next();
		String password = sc.next();
		Customer loggedCustomer = null;
		for(Customer customer : customers)
		{
			if(customer.getAccno().equals(accno) && customer.getPassword().equals(password)) {
				System.out.println("Login Successsful!! ");
				loggedCustomer = customer;
				break;
			}
		}
		
		// lint errors
		if(loggedCustomer == null)
			System.out.println("Login unsuccessful, Invalid Credentials");
		else {
			Banking banking = new Banking(new OTPGenerator());
			int choice =0;
			do {
				System.out.println("Please choose one of the following");
				System.out.println("1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. Logout");
				choice = sc.nextInt();
				double amount = 0.0;
				switch(choice)
				{
				case 1:
					System.out.println("Enter amount to withdraw");
					amount = sc.nextDouble();
					System.out.println(banking.withdraw(amount, loggedCustomer));
					break;
					
				case 2:
					System.out.println("Enter amount to deposit");
					amount = sc.nextDouble();
					System.out.println(banking.deposit(amount, loggedCustomer));
					break;
					
				case 3:
					System.out.println("Enter amount to transfer");
					amount = sc.nextDouble();
					banking.transfer(loggedCustomer, customers.get(2), amount);
					System.out.println("Amount transfered from "+loggedCustomer.getAccno()
					+" and balance is "+loggedCustomer.getBalance());
					System.out.println("Amount transfered to "+ customers.get(2).getAccno()
					+" and balance is "+ customers.get(2).getBalance());
					break;
				
				case 4:
					System.out.println("Balance is "+loggedCustomer.getBalance());
					break;
					
				case 5:
					System.out.println("Thanks for visiting");
					System.exit(0);
					break;
					
				default:
						System.out.println("Wrong choice");
				}
			}while(choice!=5);
		}
		
		sc.close();

	}

}
