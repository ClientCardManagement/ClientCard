package com.ClientCardManagement.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.TrnNcService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
public class TrnNcServiceBean implements TrnNcService {
	
	private String userid;

	@Resource
	private SessionFactory sessionFactory;

	public void save(TrnNc o) {
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(TrnNc o) {
		// 将游离对象更新到数据库
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(TrnNc.class,
						Long.parseLong(id)));

	}

	public TrnNc get(String id) {
		return (TrnNc) sessionFactory.getCurrentSession().get(TrnNc.class,
				Long.parseLong(id));
	}

	public List<TrnNc> getList(String ids) {
		// ids 为 逗号分隔的字符串
		// 1,2,333,1
		String[] idArray = ids.split(",");
		int M = idArray.length;
		if (M <= 0) {
			return null;
		}
		List<TrnNc> list = new ArrayList<TrnNc>();
		for(String id:idArray){
			list.add(get(id));
		}
		return list;
	}

	public List<TrnNc> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TrnNc as tn where tn.trnMid.sharekub = 0 order by tn.id");

		return (List<TrnNc>) query.list();
	}

	public List<TrnNc> getList(int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TrnNc as tn where tn.trnMid.sharekub = 0 order by tn.id");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnNc>) query.list();
	}

	public Long totalNum() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(*) from TrnNc as tn where tn.trnMid.sharekub = 0 ");
		return (Long) query.uniqueResult();
	}

	public Long totalSearchNum(String comjnam, String name) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam like :comjnam and tn.firstnam like :name and tn.secdnam like :name ");
		query.setString("comjnam", "%" + comjnam + "%");
		query.setString("name", "[" + name + "]");
		return (Long) query.uniqueResult();
	}

	public List<TrnNc> search(String comjnam, String name, int begin, int end) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam like :comjnam and tn.firstnam like :name and tn.secdnam like :name order by tn.id");
		query.setString("comjnam", "%" + comjnam + "%");
		query.setString("name", "[" + name + "]");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnNc>) query.list();
	}

	/**********************    MyCard Part *************************************/
	public List<TrnNc> getMyList(){
		ActionContext ctx = ActionContext.getContext();
		userid = String.valueOf((ctx.getSession().get("userid")));
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnNc as tn where tn.trnMid.crtusr=? order by tn.id desc");
		query.setString(0, userid);
		return (List<TrnNc>) query.list();
	}


	public List<TrnNc> getMyList(int begin, int end) {

		ActionContext ctx = ActionContext.getContext();
		userid = String.valueOf((ctx.getSession().get("userid")));
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnNc as tn where tn.trnMid.crtusr=? order by tn.id desc");
		query.setString(0, userid);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnNc>) query.list();
	}

	public Long myTotalNum() {
		ActionContext ctx = ActionContext.getContext();
		userid = String.valueOf((ctx.getSession().get("userid")));
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select count(*) from TrnNc as tn where tn.trnMid.crtusr=?");
		query.setString(0, userid);
		return (Long ) query.uniqueResult();

	}

	public Long myTotalSearchNum(String comjnam,String name) {
		ActionContext ctx = ActionContext.getContext();
		userid = String.valueOf((ctx.getSession().get("userid")));
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select count(*) from TrnNc as tn where  tn.trnMid.crtusr=? and (tn.comjnam like :comjnam or tn.firstnam like :name or tn.secdnam like :name) ");
		query.setString(0, userid);
		query.setString("comjnam", "%"+comjnam+"%");
		query.setString("name", "["+name+"]");	
		return (Long ) query.uniqueResult();

	}


	public List<TrnNc> mySearch(String comjnam,String name,int begin, int end){
		ActionContext ctx = ActionContext.getContext();
		userid = String.valueOf((ctx.getSession().get("userid")));
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnNc as tn where tn.trnMid.crtusr=? and (tn.comjnam like :comjnam or tn.firstnam like :name or tn.secdnam like :name order by tn.id)");
		query.setString(0, userid);
		query.setString("comjnam", "%"+comjnam+"%");
		query.setString("name", "["+name+"]");

		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnNc>) query.list();
	}
	/********************* myCard Part End ************************************************/
	
	public String searchUsername(String userid){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select usernam from MstUser as mu where mu.userid = ?");
		query.setString(0, userid);
		
		return (String)query.uniqueResult();
	}
}
