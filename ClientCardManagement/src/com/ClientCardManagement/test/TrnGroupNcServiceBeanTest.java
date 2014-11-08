package com.ClientCardManagement.test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.TrnGroupNc;
import com.ClientCardManagement.service.TrnGroupNcService;



public class TrnGroupNcServiceBeanTest {
	private ApplicationContext applicationContext;
	private TrnGroupNcService TrnGroupNcService;


	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TrnGroupNcService = (TrnGroupNcService) applicationContext
				.getBean("trnGroupNcServiceBean");
		
	}

	@Test
	public void testGetList() {
		List<TrnGroupNc> list = TrnGroupNcService.getList();
		System.out.println(list.get(0).getId());
		assertTrue(list.size() >0);
	}


}
