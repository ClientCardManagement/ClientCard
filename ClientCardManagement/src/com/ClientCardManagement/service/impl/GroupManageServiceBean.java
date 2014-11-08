package com.ClientCardManagement.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.service.GroupManageService;

@Service
@Transactional
public class GroupManageServiceBean implements GroupManageService{
	@Resource
	private SessionFactory sessionFactory;

	public void save(TrnGroup o) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		o.setCopid("1");
		o.setCrttim(timestamp);
		o.setUpdtim(timestamp);
		o.setCrtusr(10001L);
		o.setUpdusr("10001");
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(TrnGroup o) {
		// 将游离对象更新到数据库
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		o.setCopid("1");
		o.setUpdtim(timestamp);
		o.setUpdusr("10001");
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(TrnGroup.class, Long.parseLong(id)));

	}

	public TrnGroup get(String id) {
		return (TrnGroup) sessionFactory.getCurrentSession().get(
				TrnGroup.class, Long.parseLong(id));
	}

	public List<TrnGroup> getList(String userid) {
		String hql = "from TrnGroup as tg where tg.mstUser.userid="+ userid +" order by groupid desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<TrnGroup>) query.list();
	}
	
	public List<TrnGroup> getPraList(String userid) {
		String hql = "from TrnGroup as tg where tg.prgroupid is null and tg.mstUser.userid="+ userid +" order by tg.groupid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<TrnGroup>) query.list();
	}
	
	public List<TrnGroup> getChiList(String userid) {
		String hql = "from TrnGroup as tg where tg.prgroupid is not null and tg.mstUser.userid="+ userid +" order by tg.groupid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<TrnGroup>) query.list();
	}

	public List<TrnGroup> getList(String userid,int begin, int end) {
		String hql = "from TrnGroup as tg where tg.mstUser.userid="+ userid +" order by groupid desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//System.out.println(userid);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnGroup>) query.list();
	}

	public Long totalNum(String userid) {
		String hql = "select count(*) from TrnGroup as tg where tg.mstUser.userid="+ userid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Long ) query.uniqueResult();
	}

}
