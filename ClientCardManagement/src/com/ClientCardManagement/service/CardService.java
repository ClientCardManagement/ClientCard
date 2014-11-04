package com.ClientCardManagement.service;

import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;

public interface CardService {

	public void save(TrnMid trnMid, TrnNc trnNc);
	
	public void update(TrnNc trnNc);
	
	public TrnNc get(String id);
	
	public void delete(String id);
}