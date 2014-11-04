package com.ClientCardManagement.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.UserService;

@Service
@Transactional
public class UserServiceBean implements UserService {
	@Resource
	private SessionFactory sessionFactory;

	public void save(MstUser o) {

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		o.setCrttim(ts);
		o.setUsernam(o.getUsernam().trim());
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String password = o.getPassword();
		o.setPassword(passwordEncryptor.encryptPassword(password));
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(MstUser o) {
		// 将游离对象更新到数据库
		String id = o.getUserid().toString();
		MstUser oldUser = get(id);
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String oldPassword = oldUser.getPassword();
		// 密码改变了
		if (!o.getPassword().equals(oldPassword)) {
			// 加密现在的新密码
			o.setPassword(passwordEncryptor.encryptPassword(o.getPassword()));
		}
		o.setUsernam(o.getUsernam().trim());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		o.setUpdtim(ts);
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(MstUser.class,
						Long.parseLong(id)));

	}

	public MstUser get(String id) {
		return (MstUser) sessionFactory.getCurrentSession().get(MstUser.class,
				Long.parseLong(id));
	}

	public List<MstUser> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from MstUser order by userid");
		return (List<MstUser>) query.list();
	}

	public List<MstUser> getList(int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from MstUser order by userid");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<MstUser>) query.list();
	}

	public Long totalNum() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(*) from MstUser");
		return (Long) query.uniqueResult();
	}

	public List<MstUser> query(String hql, List values, int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int N = values.size();
		for (int i = 0; i < N; i++) {
			query.setParameter(i, values.get(i));
		}
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<MstUser>) query.list();
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
