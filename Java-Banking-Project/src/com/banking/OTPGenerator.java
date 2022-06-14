package com.banking;

public class OTPGenerator {
	
	public int generateOtp()
	{
		int otp = (int)(Math.random()*9000) + 1000;
		return otp;
	}

}
