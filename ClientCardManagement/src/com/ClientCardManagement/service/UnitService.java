package com.ClientCardManagement.service;

import java.util.List;

import com.ClientCardManagement.model.MstUnit;

public interface UnitService {

	public void save(MstUnit o);

	public void update(MstUnit o);

	public void delete(String id);

	public MstUnit get(String id);

	public List<MstUnit> getList();

	public List<MstUnit> getList(int begin, int end);

	public Long totalNum();

}