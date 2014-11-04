package com.ClientCardManagement.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.service.QueryService;


@Service
@Transactional
public class QueryServiceBean implements QueryService {
	@Resource
	private SessionFactory sessionFactory;

	public List query(String hql, List values, int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int N = values.size();
		for (int i = 0; i < N; i++) {
			query.setParameter(i, values.get(i));
		}
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return query.list();
	}

	public Long queryNum(String hql, List values) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int N = values.size();
		for (int i = 0; i < N; i++) {
			query.setParameter(i, values.get(i));
		}
		return (Long) query.uniqueResult();
	}
}
