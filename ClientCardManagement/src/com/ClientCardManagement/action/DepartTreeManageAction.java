package com.ClientCardManagement.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.DepartNode;
import com.ClientCardManagement.model.DepartTree;
import com.ClientCardManagement.service.DepartTreeService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class DepartTreeManageAction extends ActionSupport {

	/**
	 * 
	 */
	
	@Resource
	private DepartTreeService departTreeService;
	private DepartTree trees;
	private List<DepartNode> nodes;
	private DepartNode node;
	private String needSearchURL = "0";
	
	public String getNeedSearchURL() {
		return needSearchURL;
	}

	public void setNeedSearchURL(String needSearchURL) {
		this.needSearchURL = needSearchURL;
	}

	public DepartTree getTrees() {
		return trees;
	}

	public void setTrees(DepartTree trees) {
		this.trees = trees;
	}

	public String initTree(){
		trees = departTreeService.getCompanys();
		trees = departTreeService.getDeparts(trees);
		trees = departTreeService.getNoDepartNodes(trees);
		trees = departTreeService.getLeafNodes(trees);
		nodes = trees.getTrees();
		Iterator<DepartNode> iter = nodes.iterator();
		while (iter.hasNext()) {
			node = iter.next();
			node.setName(node.getName().trim());
		}
		return SUCCESS;
	}

	
}
