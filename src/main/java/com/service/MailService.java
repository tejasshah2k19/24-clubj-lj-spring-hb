package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendOtpForgetPassword(String to,String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("OTP for Reset Password");
		message.setText("Please use below OTP for Reset Password : "+otp);
 		
		mailSender.send(message);
	}
}
