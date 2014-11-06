package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ClientCardManagement.model.DepartNode;
import com.ClientCardManagement.model.DepartTree;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.DepartTreeService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;
import com.ClientCardManagement.service.UserService;

public class DepartTreeServiceBeanTest {
	private ApplicationContext applicationContext;
	private DepartTreeService departTreeService;
	private DepartTree trees;
	private List<DepartNode> nodes;
	private List<DepartNode> leafs;
	private DepartNode depart;
	private DepartNode node;
	private DepartNode leaf;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		departTreeService = (DepartTreeService) applicationContext
				.getBean("departTreeServiceBean");

	}

	//@Test
	public void testBlank() {
		String a = " ";
		System.out.println("-" + a.trim() + "-" + a.trim().length());
	}

	//@Test
	public void testGetDepartTree() {
		trees = departTreeService.getCompanys();
		// System.out.println(trees);
		
		trees = departTreeService.getDeparts(trees);
		trees = departTreeService.getNoDepartNodes(trees);
		trees = departTreeService.getLeafNodes(trees);
		nodes = trees.getTrees();
		Iterator<DepartNode> iter = nodes.iterator();
		while (iter.hasNext()) {
			node = iter.next();
			System.out.println("公司:" + node.getName().trim());
			Iterator<DepartNode> iterSeconde = node.getList().iterator();
			while (iterSeconde.hasNext()) {
				depart = iterSeconde.next();
				
				
				System.out.println(depart);
				if (!depart.getIsLeaf()) {
					leafs = depart.getList();
					Iterator<DepartNode> iterThird = leafs.iterator();
					while (iterThird.hasNext()) {
						leaf = iterThird.next();
						System.out.println(leaf);
					}
				}
				System.out.println("=========");
			}

		}
	}
	

}
