package com.ClientCardManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.UserService;

@Service
@Transactional
public class TrnMidServiceBean implements TrnMidService {
	@Resource
	private SessionFactory sessionFactory;

	public void save(TrnMid o) {
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(TrnMid o) {
		// 将游离对象更新到数据库
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(TrnMid.class, Long.parseLong(id)));

	}

	public TrnMid get(String id) {
		return (TrnMid) sessionFactory.getCurrentSession().get(
				TrnMid.class, Long.parseLong(id));
	}
	public TrnMid getByCreateUserId(String id){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnMid as tm where tm.crtusr=? order by tm.crttim desc, tm.midid desc");
		query.setString(0, id);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List list = query.list();
		if(list.size()>=0){
			return (TrnMid) list.get(0);
		}
		return null;
	}
	public List<TrnMid> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TrnMid order by midid");
		
		return (List<TrnMid>) query.list();
	}

	public List<TrnMid> getList(int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnMid order by midid");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnMid>) query.list();
	}

	public Long totalNum() {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select count(*) from TrnMid");
		return (Long ) query.uniqueResult();
	}


	

}
