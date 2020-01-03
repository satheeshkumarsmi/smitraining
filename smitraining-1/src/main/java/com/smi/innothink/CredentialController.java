package com.smi.innothink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.domain.ChangePassword;
import com.smi.innothink.domain.UserCredentials;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.repository.TrainerRepository;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class CredentialController {
	static Logger log = Logger.getLogger("StudentController.class");
	@Autowired(required = false)
	UserCredentials userCredentials;
	@Autowired(required = false)
	StudentRepository studentRepository;
	@Autowired(required = false)
	TrainerRepository trainerRepository;
	@Autowired(required = false)
	HttpSession session;
	@Autowired(required = false)
	JavaMailSender sender;
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST, produces = "application/json")
	public  ArrayList<Object> userLogin(@RequestBody UserCredentials userCredentials){
		//Map map=new HashMap();
		ArrayList<Object> al = new ArrayList<Object>();
		String userName=userCredentials.getUserName();
		String password=userCredentials.getPassword();
	    if(userName.substring(0,11).equals("SMI_IT_STU_")) {
	    	System.out.println("Student");
	    	if(studentRepository.checkCredentials(userName,password).length()>5) {
	    		session.setAttribute("LoggedIn", studentRepository.getStudent(userName));	
	    		
	    		 al.add(session.getAttribute("LoggedIn"));
	    	}
	    }
	    if(userName.substring(0,11).equals("SMI_IT_TRA_")) {
	    	if(trainerRepository.checkCredential(userName, password).length()>5) {
	    		session.setAttribute("LoggedIn",trainerRepository.getTrainer(userName));
	    	
	    		al.add(session.getAttribute("LoggedIn"));
	    	}
	    }
	    return al;
	}
	
	
	@RequestMapping(value="/userlogout",method = RequestMethod.GET, produces = "application/json")
	public Object userLogout() {
		session.setAttribute("LoggedIn", null);
		return session.getAttribute("LoggedIn");
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST, produces = "application/json")
	public boolean changePassword(@RequestBody ChangePassword changePassword) {
		String userName = changePassword.getUserName();
	    String oldPassword = changePassword.getOldPassword();
	    String newPassword = changePassword.getNewPassword();
	    String studentId=studentRepository.checkCredentials(userName,oldPassword);
	    if(studentId.equals(userName)) {
	    	studentRepository.changeOldPassword(userName, newPassword);
	    	String res=studentRepository.checkCredentials(userName,newPassword);
	    	if(res.equals(userName)) {
	    	return true;
	    }
	    else{
 		return false;
	    }}
	    else {
		return false;
	    }
	}
	
	@RequestMapping(value="/forgetpassword" , method = RequestMethod.POST , produces = "application/json")
	public boolean forgetPassword(@RequestParam String mailId)
	{
		String password=studentRepository.getPassword(mailId);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mailId);
		message.setSubject("SMI trainee, Your Password");
		message.setText("Hi, Your request for asking the password is success. your password is :  "+password+"");
		sender.send(message);
		return true;
		
	}
	
}
