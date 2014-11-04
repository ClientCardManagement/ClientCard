package com.ClientCardManagement.service;

import java.util.List;

import com.ClientCardManagement.model.MstUser;

public interface UserService {

	public void save(MstUser o);

	public void update(MstUser o);

	public void delete(String id);

	public MstUser get(String id);

	public List<MstUser> getList();

	public List<MstUser> getList(int begin, int end);

	public Long totalNum();
	public Long queryNum(String hql, List values);
	public List<MstUser> query(String hql, List values,int begin,int end);
}