package com.smi.innothink.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class MailSending {
	
		@Autowired
	    JavaMailSender sender;
	 public  void sendMail(String mail,String userName,String password,String name) {
		 SimpleMailMessage message=new SimpleMailMessage();
		 message.setTo(mail);
		 message.setSubject("SMI trainee Username and Password");
		 message.setText("Hello"+name+"Welcome to SMI Innothink.Your Username:"+userName+"and Your Password:"+password);
		 sender.send(message);
	 }
	// message.setSubject("");
	 //message.setText("");
	 //message.setTo("");
	 //sender.send(message);

}
