package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.MstUnit;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.UnitService;
import com.ClientCardManagement.service.UserService;

public class UnitServiceBeanTest {
	private ApplicationContext applicationContext;
	private UnitService unitService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		unitService = (UnitService) applicationContext
				.getBean("utilServiceBean");
	}

	@Test
	public void testGetList() {
		List<MstUnit> list = unitService.getList();
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void save() {
		String unitname = "索丹丹";
		MstUnit user = new MstUnit(unitname, true, (short)1, "zhuge","zhuge");
		user.setUnitnam(unitname);

		unitService.save(user);
		List<MstUnit> list = unitService.getList();
		assertTrue((list.get(list.size() - 1)).getUnitnam().equals(unitname));
	}

	

}
