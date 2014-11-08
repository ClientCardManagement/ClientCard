package com.ClientCardManagement.service;

import java.util.List;

import com.ClientCardManagement.model.TrnGroup;

public interface GroupManageService {

	public void save(TrnGroup o);

	public void update(TrnGroup o);

	public void delete(String id);

	public TrnGroup get(String id);

	public List<TrnGroup> getList(String userid);

	public List<TrnGroup> getList(String userid,int begin, int end);

	public Long totalNum(String userid);
	
	public List<TrnGroup> getPraList(String userid) ;
	
	public List<TrnGroup> getChiList(String userid) ;

}