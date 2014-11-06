package com.ClientCardManagement.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.DepartNode;
import com.ClientCardManagement.model.DepartTree;
import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.DepartTreeService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;

@Service
@Transactional
public class DepartTreeServiceBean implements DepartTreeService {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private TrnNcService trnNcService;

	public DepartTree getCompanys() {

		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select tn.comjnam from  TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam!=null and tn.comjnam !=:blank group by tn.comjnam ");
		DepartTree trees = new DepartTree();
		String blank = "";
		query.setString("blank", blank);
		List result = query.list();
		Collections.reverse(result);
		int N = result.size();
		String name;
		Object o;
		for (int i = 0; i < N; i++) {
			o = (Object) result.get(i);
			name = null;
			if (o != null) {
				name = o.toString();
			}
			trees.addTree(new DepartNode("", false, name));
		}

		return trees;
	}

	public DepartTree getDeparts(DepartTree trees) {
		Query query;
		String hql = "select tn.postnam from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam = :company and tn.postnam != null and tn.postnam != :blank group by tn.postnam ";
		String blank = "";
		List result;
		String company;
		DepartNode node;
		String name;
		Object o;
		List<DepartNode> oldTrees = trees.getTrees();
		int N = oldTrees.size();
		int M;
		for (int i = 0; i < N; i++) {
			query = sessionFactory.getCurrentSession().createQuery(hql);
			node = oldTrees.get(i);
			company = node.getName();
			query.setString("company", company);
			query.setString("blank", blank);
			result = query.list();
			M = result.size();
			for (int j = 0; j < M; j++) {
				o = (Object) result.get(j);
				name = null;
				if (o != null) {
					name = o.toString();
				}
				node.addNode((new DepartNode("", false, name)));
			}
		}
		return trees;
	}

	public DepartTree getNoDepartNodes(DepartTree trees) {
		Query query;
		String hql = "select tn.id, tn.firstnam,tn.secdnam from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam = :company and tn.postnam = null or tn.comjnam = :company and tn.postnam = :blank order by tn.id";
		String blank = "";
		List result;
		String company;
		DepartNode node;
		String firstname;
		String scondname;
		String name;
		String id;
		Object[] o;
		List<DepartNode> oldTrees = trees.getTrees();
		int N = oldTrees.size();
		int M;
		for (int i = 0; i < N; i++) {
			query = sessionFactory.getCurrentSession().createQuery(hql);
			node = oldTrees.get(i);
			company = node.getName();
			query.setString("company", company);
			query.setString("blank", blank);
			result = query.list();
			M = result.size();
			for (int j = 0; j < M; j++) {
				o = (Object[]) result.get(j);
				firstname = null;
				scondname = null;
				name = null;
				id = null;
				if (o != null) {
					if (o[0] != null) {
						id = o[0].toString().trim();
					}
					if (o[1] != null) {
						firstname = o[1].toString();
						if (firstname != null) {
							name = firstname.trim();
						}
					}
					if (o[2] != null) {
						scondname = o[2].toString();
						if (scondname != null) {
							if (name != null) {
								name += scondname.trim();
							} else {
								name = scondname.trim();
							}

						}
					}

					node.addNode((new DepartNode(id, true, name)));
				}

			}
		}
		return trees;
	}

	public DepartTree getLeafNodes(DepartTree trees) {
		Query query;
		String hql = "select tn.id, tn.firstnam,tn.secdnam from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam = :company and tn.postnam = :postnam order by tn.id";

		List result;
		String company;
		String postnam;
		DepartNode root;
		List<DepartNode> departs;
		DepartNode node;
		String firstname;
		String scondname;
		String name;
		String id;
		Object[] o;
		List<DepartNode> oldTrees = trees.getTrees();
		int N = oldTrees.size();
		int M;
		int D;
		for (int i = 0; i < N; i++) {
			root = oldTrees.get(i);
			if (root.getIsLeaf() == true) {
				continue;
			}

			company = root.getName();
			departs = root.getList();
			D = departs.size();
			for (int k = 0; k < D; k++) {
				node = departs.get(k);
				postnam = node.getName();
				query = sessionFactory.getCurrentSession().createQuery(hql);
				query.setString("company", company);
				query.setString("postnam", postnam);
				result = query.list();

				M = result.size();
				for (int j = 0; j < M; j++) {
					o = (Object[]) result.get(j);
					firstname = null;
					scondname = null;
					name = null;
					id = null;
					if (o != null) {
						if (o[0] != null) {
							id = o[0].toString().trim();
						}
						if (o[1] != null) {
							firstname = o[1].toString();
							if (firstname != null) {
								name = firstname.trim();
							}
						}
						if (o[2] != null) {
							scondname = o[2].toString();
							if (scondname != null) {
								if (name != null) {
									name += scondname.trim();
								} else {
									name = scondname.trim();
								}

							}
						}

						node.addNode((new DepartNode(id, true, name)));
					}

				}
			}

		}
		return trees;
	}
}
