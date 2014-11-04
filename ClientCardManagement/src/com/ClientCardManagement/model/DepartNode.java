package com.ClientCardManagement.model;

import java.util.ArrayList;
import java.util.List;

public class DepartNode {
	private String id;
	private Boolean isLeaf;
	private String name;
	private List<DepartNode> list;

	public DepartNode() {
		super();
	}

	public DepartNode(String id, Boolean isLeaf, String name) {
		super();
		this.id = id;
		this.isLeaf = isLeaf;
		this.name = name;
		list = new ArrayList<DepartNode>();
	}

	public void addNode(DepartNode node) {
		list.add(node);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DepartNode> getList() {
		return list;
	}

	public void setList(List<DepartNode> list) {
		this.list = list;
	}

	public String toString() {
		String out = "Node - id:" + id + " isLief:" + isLeaf + " name:" + name;
		if(isLeaf){
			return "叶子:"+out;
		}
		return "结点:"+out; 
	}
}
