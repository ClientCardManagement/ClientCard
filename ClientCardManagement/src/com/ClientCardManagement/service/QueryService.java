package com.ClientCardManagement.service;

import java.util.List;

public interface QueryService {

	public List query(String hql, List values, int begin, int end);

	public Long queryNum(String hql, List values);

}