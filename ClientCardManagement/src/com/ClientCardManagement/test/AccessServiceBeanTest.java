package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.AccessNc;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnAccess;
import com.ClientCardManagement.model.TrnGroupNc;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.TrnAccessService;
import com.ClientCardManagement.service.TrnGroupNcService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;
import com.ClientCardManagement.service.UserService;

public class AccessServiceBeanTest {
	private ApplicationContext applicationContext;
	private TrnGroupNcService trnGroupNcService;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		trnGroupNcService = (TrnGroupNcService) applicationContext
		.getBean("trnGroupNcServiceBean");
	}

	
}
