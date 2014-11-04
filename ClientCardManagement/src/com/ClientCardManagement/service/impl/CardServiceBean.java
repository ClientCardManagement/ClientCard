package com.ClientCardManagement.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;

@Service
@Transactional
public class CardServiceBean implements CardService{
	
	@Resource
	private TrnMidService trnMidService;
	@Resource 
	private TrnNcService trnNcService;
	
	public void save(TrnMid trnMid,TrnNc trnNc){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		trnMid.setCrttim(ts);
		trnMidService.save(trnMid);
		TrnMid tm = trnMidService.getByCreateUserId(trnMid.getCrtusr());
		if(tm!=null){
			trnNc.setCrttim(ts);
			trnNc.setTrnMid(tm);
			trnNcService.save(trnNc);
		}
	}

	public TrnNc get(String id){
		TrnNc tn = trnNcService.get(id);
		//tn.setTrnMid(trnMidService.get(id));
		return tn;
	}
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	public void update(TrnNc trnNc) {
		// TODO Auto-generated method stub
		
	}
	
}
