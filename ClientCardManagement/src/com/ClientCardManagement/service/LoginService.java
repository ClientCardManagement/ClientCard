package com.ClientCardManagement.service;

import com.ClientCardManagement.model.MstUser;

public interface LoginService {

	public boolean hasUser(String name);

	public boolean checkUserLogin(MstUser user,String name, String password);

	public MstUser getUserFromName(String name);
}