package com.ClientCardManagement.service;

import java.util.List;

import com.ClientCardManagement.model.GroupNc;
import com.ClientCardManagement.model.TrnGroupNc;
import com.ClientCardManagement.model.TrnNc;

public interface TrnGroupNcService {

	public void save(TrnGroupNc o);

	public void update(TrnGroupNc o);

	public void delete(String id);

	public TrnGroupNc get(String id);

	public List<TrnGroupNc> getList();

	public List<TrnGroupNc> getList(int begin, int end);

	public Long totalNum();
	
	public List<GroupNc> searchGroupCard(Long id,int begin, int end);
	
	public Long searchGroupCardNum(Long id);
	
	public List<GroupNc> searchGroupCard(Long id);

}