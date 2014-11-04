package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;
import com.ClientCardManagement.service.UserService;

public class CardServiceBeanTest {
	private ApplicationContext applicationContext;
	private CardService cardService;
	private TrnMidService trnMidService;
	private TrnNcService trnNcService;
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		cardService = (CardService) applicationContext
		.getBean("cardServiceBean");
		trnMidService = (TrnMidService) applicationContext
		.getBean("trnMidServiceBean");
		trnNcService = (TrnNcService) applicationContext
		.getBean("trnNcServiceBean");
		userService = (UserService) applicationContext
		.getBean("userServiceBean");
	}

	//@Test
	public void testGetList() {
		System.out.println("=======MID==========");
		System.out.println(trnMidService.getList());
		System.out.println("=======NC==========");
		System.out.println(trnNcService.getList());
	}

	//@Test
	public void save() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		TrnMid tm = new TrnMid();
		tm.setCrttim(ts);
		MstUser user = userService.getList().get(0);
		System.out.println(user.getUserid()+" - "+user.getUsernam());
		tm.setCrtusr(user.getUserid().toString());
		
		TrnNc tn = new TrnNc();
		//tn.setComenam("汉字");
		tn.setComjnam("gds");
		//tn.setComjnamkn("sdfs");
		//tn.setFax1("sdfs");
		
		//tn.setCrttim(ts);
		tn.setCrtusr(user.getUserid().toString());
		cardService.save(tm, tn);
	}
	//@Test
	public void update() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		TrnNc tn = trnNcService.get("394");
		TrnMid tm = trnMidService.get(tn.getTrnMid().getMidid().toString());
		System.out.println("========="+tm);
		tm.setCrttim(ts);	
		tm.setCrtusr("222");
		
		tn.setComenam("happhdf");
		tn.setComjnam("没有吗垫付的");
		tn.setComjnamkn("是东方闪电");
		tn.setFax1("sdfs");
		tn.getTrnMid().setMidback("sdfsd");
		tn.setCrttim(ts);
	//	tn.setCrtusr(user.getUserid().toString());
	//	cardService.save(tm, tn);
		//tn.setTrnMid(tm);
		trnMidService.update(tm);
		trnNcService.update(tn);
		
	}
	//@Test
	public void testGetByCreateUserId(){
		System.out.println(trnMidService.getByCreateUserId("10001").getMidid());
	} 
	//@Test
	public void testGet(){
		TrnNc tn = cardService.get("2");
		System.out.println("++++++++0+"+tn.getTrnMid());
		System.out.println("++++++++0+"+tn);
		
		tn = trnNcService.get("2");
		//System.out.println("++++++++0+"+tn.getTrnMid().getCrtusr());
		
	}
	
}
