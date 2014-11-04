package com.ClientCardManagement.service.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.LoginService;


@Service
@Transactional
public class LoginServiceBean implements LoginService {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public boolean hasUser(String name) {
		MstUser user = getUserFromName(name);
		return user != null;
	}
	
	public boolean checkUserLogin(MstUser user,String name, String password) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		user = getUserFromName(name);
		if (user != null && passwordEncryptor.checkPassword(password,user.getPassword())) {
//		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	public MstUser getUserFromName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from MstUser as u where u.usernam=:name");
		query.setString("name", name);
		return (MstUser) query.uniqueResult();
	}
}
