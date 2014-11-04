package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.LoginService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;
import com.ClientCardManagement.service.UserService;

public class LoginServiceBeanTest {
	private ApplicationContext applicationContext;
	

	private LoginService service;
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		service = (LoginService) applicationContext
		.getBean("loginServiceBean");
		userService = (UserService) applicationContext
		.getBean("userServiceBean");
	}

	

	
	@Test
	public void testUser(){
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		//String password = o.getPassword();
		//o.setPassword(passwordEncryptor.encryptPassword(password));
		
	} 
	
}
