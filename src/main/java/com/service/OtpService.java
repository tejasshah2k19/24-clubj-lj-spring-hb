package com.service;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

	public String generateAlnumOtp(int size) {
		String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		StringBuffer otp  = new StringBuffer();
		for(int i=1;i<=size;i++) {
			int index = (int)(Math.random()*data.length()); 
			otp.append(data.charAt(index));
		}
		
		return otp.toString();
	}
}
