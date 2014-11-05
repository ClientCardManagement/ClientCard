package com.ClientCardManagement.service;

import java.sql.Date;

import java.util.List;

import com.ClientCardManagement.model.AccessNc;
import com.ClientCardManagement.model.TrnAccess;

public interface TrnAccessService {

	public void save(TrnAccess o);

	public void update(TrnAccess o);

	public void delete(String id);

	public TrnAccess get(String id);

	public List<AccessNc> getList(String userid);

	public List<AccessNc> getList(String userid,int begin, int end);

	public Long totalNum(String userid);

	public Long totalSearchNum(String userid,String usernam,String comjnam,String finam,String scnam,Date betime,Date entime);
	
	public List<AccessNc> search(String userid,String usernam,String comjnam,String finam,String scnam,Date betime,Date entime,int begin, int end);
}