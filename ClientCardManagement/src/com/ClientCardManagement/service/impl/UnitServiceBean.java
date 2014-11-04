package com.ClientCardManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ClientCardManagement.model.MstUnit;
import com.ClientCardManagement.service.UnitService;


@Service
@Transactional
public class UnitServiceBean implements UnitService{
	@Resource
	private SessionFactory sessionFactory;

	public void save(MstUnit o) {
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(MstUnit o) {
		// 将游离对象更新到数据库
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(MstUnit.class, Long.parseLong(id)));

	}

	public MstUnit get(String id) {
		return (MstUnit) sessionFactory.getCurrentSession().get(
				MstUnit.class, Long.parseLong(id));
	}

	public List<MstUnit> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from MstUnit order by unitId");
		
		return (List<MstUnit>) query.list();
	}

	public List<MstUnit> getList(int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from MstUnit order by unitId");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<MstUnit>) query.list();
	}

	public Long totalNum() {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select count(*) from MstUnit");
		return (Long ) query.uniqueResult();
	}

}
