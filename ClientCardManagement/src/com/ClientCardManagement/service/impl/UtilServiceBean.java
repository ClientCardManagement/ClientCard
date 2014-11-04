package com.ClientCardManagement.service.impl;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.service.UtilService;

@Service
@Transactional
public class UtilServiceBean implements UtilService{
	@Resource
	private SessionFactory sessionFactory;

	

	public void delete(String start) {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"delete MstUser where userid >= :start");
		query.setString("start", start);
		query.executeUpdate();

	}

	
}
