package com.ClientCardManagement.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.AccessNc;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnAccess;
import com.ClientCardManagement.service.TrnAccessService;

@Service
@Transactional
public class TrnAccessServiceBean implements TrnAccessService {
	@Resource
	private SessionFactory sessionFactory;

	public void save(TrnAccess o) {
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(TrnAccess o) {
		// 将游离对象更新到数据库
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(TrnAccess.class,
						Long.parseLong(id)));

	}

	public TrnAccess get(String id) {
		return (TrnAccess) sessionFactory.getCurrentSession().get(
				TrnAccess.class, Long.parseLong(id));
	}

	public List<AccessNc> getList(String userid) {
		String hql = "select ta.id,ta.mstUser,ta.compltime,tn.comjnam,tn.firstnam,tn.secdnam from TrnAccess as ta,TrnNc as tn where ta.trnMid.id = tn.trnMid.id and tn.trnMid.crtusr="
				+ userid + " order by ta.id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		List<AccessNc> resultList = new ArrayList<AccessNc>();
		int N = list.size();
		Object[] array;
		AccessNc o;
		for (int i = 0; i < N; i++) {
			array = (Object[]) list.get(i);
			o = new AccessNc((Long) array[0], (MstUser) array[1],
					(Timestamp) array[2], (String) array[3], (String) array[4],
					(String) array[5]);
			resultList.add(o);
		}
		return resultList;
	}

	public List<AccessNc> getList(String userid, int begin, int end) {
		String hql = "select ta.id,ta.mstUser,ta.compltime,tn.comjnam,tn.firstnam,tn.secdnam from TrnAccess as ta,TrnNc as tn where ta.trnMid.id = tn.trnMid.id and tn.trnMid.crtusr="
				+ userid + " order by ta.id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List list = query.list();
		List<AccessNc> resultList = new ArrayList<AccessNc>();
		int N = list.size();
		// System.out.println(N);
		Object[] array;
		AccessNc o;
		for (int i = 0; i < N; i++) {
			array = (Object[]) list.get(i);
			o = new AccessNc((Long) array[0], (MstUser) array[1],
					(Timestamp) array[2], (String) array[3], (String) array[4],
					(String) array[5]);
			resultList.add(o);
			// System.out.println("ok");
		}
		return resultList;
	}

	public Long totalNum(String userid) {
		String hql = "select count(*) from TrnAccess as ta,TrnNc as tn where ta.trnMid = tn.trnMid and tn.trnMid.crtusr="
				+ userid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	public Long totalSearchNum(String userid, String usernam, String comjnam,
			String finam, String scnam, Date betime, Date entime) {
		String hql = "select count(*) from TrnAccess as ta,TrnNc as tn where ta.trnMid = tn.trnMid and tn.trnMid.crtusr="
				+ userid + " ";

		if (usernam != null && !usernam.equals(""))
			hql += "and ta.mstUser.usernam like '" + usernam + "' ";
		if (comjnam != null && !comjnam.equals(""))
			hql += "and tn.comjnam like '" + comjnam + "' ";
		// if(finam !=null && !finam.equals(""))
		// hql+="and tn.firstnam like '" + finam +"' ";
		// if(scnam !=null && !scnam.equals(""))
		// hql+="and tn.secdnam like '" + scnam +"' ";

		if (finam != null && !finam.equals("")) {
			hql += " and ( tn.firstnam like '[" + finam
					+ "]%' and tn.secdnam like  '%[" + finam + "]') ";
		}
		if (betime != null && !betime.equals("") && entime != null
				&& !entime.equals(""))
			hql += "and ta.compltime between '" + betime + "' and '" + entime
					+ "' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	public List<AccessNc> search(String userid, String usernam, String comjnam,
			String finam, String scnam, Date betime, Date entime, int begin,
			int end) {

		String hql = "select ta.id,ta.mstUser,ta.compltime,tn.comjnam,tn.firstnam,tn.secdnam from TrnAccess as ta,TrnNc as tn where ta.trnMid = tn.trnMid and tn.trnMid.crtusr="
				+ userid + " ";

		if (usernam != null && !usernam.equals(""))
			hql += "and ta.mstUser.usernam like '" + usernam + "' ";
		if (comjnam != null && !comjnam.equals(""))
			hql += "and tn.comjnam like '" + comjnam + "' ";
		// if(finam !=null && !finam.equals(""))
		// hql+="and tn.firstnam like '" + finam +"' ";
		// if(scnam !=null && !scnam.equals(""))
		// hql+="and tn.secdnam like '" + scnam +"' ";
		if (finam != null && !finam.equals("")) {
			hql += " and ( tn.firstnam like '[" + finam
					+ "]%' and tn.secdnam like  '%[" + finam + "]') ";
		}
		if (betime != null && !betime.equals("") && entime != null
				&& !entime.equals(""))
			hql += "and ta.compltime between '" + betime + "' and '" + entime
					+ "' ";

		hql += "order by ta.id desc";

		// System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List list = query.list();
		List<AccessNc> resultList = new ArrayList<AccessNc>();
		int N = list.size();
		Object[] array;
		AccessNc o;
		for (int i = 0; i < N; i++) {
			array = (Object[]) list.get(i);
			o = new AccessNc((Long) array[0], (MstUser) array[1],
					(Timestamp) array[2], (String) array[3], (String) array[4],
					(String) array[5]);
			resultList.add(o);
		}
		return resultList;
	}
}
