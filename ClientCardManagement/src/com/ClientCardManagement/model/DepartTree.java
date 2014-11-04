package com.ClientCardManagement.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartTree {
	private List<DepartNode> trees;

	public DepartTree() {
		super();
		trees = new ArrayList<DepartNode>();
	}

	public List<DepartNode> getTrees() {
		return trees;
	}

	public void setTrees(List<DepartNode> trees) {
		this.trees = trees;
	}

	public void addTree(DepartNode tree) {
		trees.add(tree);
	}

	public String toString() {
		Iterator<DepartNode> iter = trees.iterator();
		StringBuffer s = new StringBuffer("DepartTree:[");
		while (iter.hasNext()) {
			s.append(iter.next().toString());
			s.append(" - ");
		}
		s.append("]");
		return s.toString();
	}

}
