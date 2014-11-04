package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.UserService;
import com.ClientCardManagement.service.UtilService;

public class UserServiceBeanTest {
	private ApplicationContext applicationContext;
	private UserService userService;
	private UtilService utilService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		userService = (UserService) applicationContext
				.getBean("userServiceBean");
		utilService = (UtilService) applicationContext
				.getBean("utilServiceBean");
	}

	// @Test
	public void testGetList() {
		List<MstUser> list = userService.getList();
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void save() {
		String name = "duoduo";
		String password = "duoduo";
		// String email = "110@qq.com";
		// MstUser user = new MstUser(name,password, "0", email,
		// 1L, 1, null, "0", "0", false, null, false, null, "0", null, "0");
		MstUser user;
		int start = 3000;
		int M = 2000;
		int N = start + M;
		for (int i = start; i < N; i++) {
			user = new MstUser();
			user.setPassword(password);
			user.setUsernam(name + i);
			user.setUserkub("0");
			userService.save(user);
		}
		

		List<MstUser> list = userService.getList();
		assertTrue(list.size() > 0);
	}

	//@Test
	public void deleteAlot() {
		utilService.delete("100026");
	}
}
