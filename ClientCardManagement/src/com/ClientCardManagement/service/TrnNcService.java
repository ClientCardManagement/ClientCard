package com.ClientCardManagement.service;

import java.util.List;

import com.ClientCardManagement.model.TrnNc;

public interface TrnNcService {

	public void save(TrnNc o);

	public void update(TrnNc o);

	public void delete(String id);

	public TrnNc get(String id);

	public List<TrnNc> getList();
	public List<TrnNc> getList(String ids);
	public Long totalSearchNum(String comjnam,String name);
	public List<TrnNc> getList(int begin, int end);
	public List<TrnNc> search(String comjnam,String name,int begin, int end);
	public Long totalNum();
	
	public List<TrnNc> getMyList();
	public List<TrnNc> getMyList(int begin, int end);
	public Long myTotalSearchNum(String comjnam,String name);
	public Long myTotalNum();
	public List<TrnNc> mySearch(String comjnam,String name,int begin, int end);
	public String searchUsername(String userid);

}