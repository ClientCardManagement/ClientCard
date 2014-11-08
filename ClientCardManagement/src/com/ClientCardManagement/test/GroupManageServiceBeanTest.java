package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.service.GroupManageService;
import com.ClientCardManagement.service.UserService;
import com.ClientCardManagement.service.impl.UserServiceBean;

public class GroupManageServiceBeanTest {
	private ApplicationContext applicationContext;
	private GroupManageService groupManageService;
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		groupManageService = (GroupManageService) applicationContext
				.getBean("groupManageServiceBean");
		userService = (UserService) applicationContext
		.getBean("userServiceBean");
	}

	@Test
	public void testGetList() {
		List<TrnGroup> list = groupManageService.getChiList("10001");
		System.out.println(list);
		//assertTrue(list.size() ==10);
	}

	//@Test
	/*public void save() {
		String name = "索丹丹";
		String userid = "10001";

		
		String updusr = "10001";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		TrnGroup groupManage = new TrnGroup(userService.get(userid),name,"1",true,timestamp,10001L,timestamp,updusr);
		/*groupManage.setGroupManagenam(name);
		groupManage.setPassword(password);
		groupManage.setMailads(email);
		groupManageService.save(groupManage);
		List<TrnGroup> list = groupManageService.getList();
		assertTrue((list.get(list.size() - 1)).getGroupnam().equals(name));
	}*/

}
