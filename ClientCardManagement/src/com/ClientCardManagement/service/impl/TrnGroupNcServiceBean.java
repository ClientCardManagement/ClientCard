package com.ClientCardManagement.service.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ClientCardManagement.model.AccessNc;
import com.ClientCardManagement.model.GroupNc;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnGroupNc;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.TrnGroupNcService;


@Service
@Transactional
public class TrnGroupNcServiceBean implements TrnGroupNcService {
	@Resource
	private SessionFactory sessionFactory;

	public void save(TrnGroupNc o) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		o.setCrttim(timestamp);
		o.setUpdtim(timestamp);
		o.setUpdusr("10001");
		sessionFactory.getCurrentSession().persist(o);
	}

	public void update(TrnGroupNc o) {
		// 将游离对象更新到数据库
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		o.setUpdtim(timestamp);
		o.setUpdusr("10001");
		sessionFactory.getCurrentSession().merge(o);
	}

	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(TrnGroupNc.class, Long.parseLong(id)));

	}

	public TrnGroupNc get(String id) {
		return (TrnGroupNc) sessionFactory.getCurrentSession().get(
				TrnGroupNc.class, Long.parseLong(id));
	}

	public List<TrnGroupNc> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from TrnGroupNc as tg order by tg.id");
		return (List<TrnGroupNc>) query.list();
	}


	public List<TrnGroupNc> getList(int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from TrnGroupNc order by groupid");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		return (List<TrnGroupNc>) query.list();
	}

	public Long totalNum() {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"select count(*) from TrnGroupNc");
		return (Long ) query.uniqueResult();
	}
	
	public List<GroupNc> searchGroupCard(Long id,int begin, int end) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select tg.id,tn.comjnam,tn.postnam,tn.offposi,tn.firstnam,tn.secdnam,tn.id from TrnGroupNc as tg,TrnNc as tn where tg.trnMid.id = tn.trnMid.id and tg.trnGroup.groupid =:id order by tn.id");
		query.setLong("id", id);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List list = query.list();
		List<GroupNc> resultList=new ArrayList<GroupNc>();
		int N = list.size();
		//System.out.println(N);
		Object[] array;
		GroupNc o;
		for(int i =0;i< N;i++){
			array=(Object[]) list.get(i);
			o = new GroupNc();
			o.setId((Long)array[0]);
			o.setComjnam((String)array[1]);
			o.setPostnam((String)array[2]);
			o.setOffposi((String)array[3]);
			o.setFirstnam((String)array[4]);
			o.setSecdnam((String)array[5]);
			o.setSid(((Long)array[6]));
			resultList.add(o);
			//System.out.println("ok");
		}
		
		return  resultList;
	}
	
	public List<GroupNc> searchGroupCard(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select tg.id,tn.comjnam,tn.postnam,tn.offposi,tn.firstnam,tn.secdnam,tn.trnMid.id,tn.id from TrnGroupNc as tg,TrnNc as tn where tg.trnMid.id = tn.trnMid.id and tg.trnGroup.groupid =:id order by tn.id");
		query.setLong("id", id);
		List list = query.list();
		List<GroupNc> resultList=new ArrayList<GroupNc>();
		int N = list.size();
		//System.out.println(N);
		Object[] array;
		GroupNc o;
		TrnMid trnmid =new TrnMid();;
		for(int i =0;i< N;i++){
			array=(Object[]) list.get(i);
			o = new GroupNc();
			o.setId((Long)array[0]);
			o.setComjnam((String)array[1]);
			o.setPostnam((String)array[2]);
			o.setOffposi((String)array[3]);
			o.setFirstnam((String)array[4]);
			o.setSecdnam((String)array[5]);
			trnmid.setMidid((Long)array[6]);
			o.setTrnMid(trnmid);
			o.setSid(((Long)array[7]));
			resultList.add(o);
			//System.out.println("ok");
		}
		return  resultList;
	}

	public Long searchGroupCardNum(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(*) from TrnGroupNc as tg,TrnNc as tn where tg.trnMid.id = tn.trnMid.id and tg.trnGroup.groupid =:id");
		query.setLong("id", id);
		
		return (Long ) query.uniqueResult();
	}

}
