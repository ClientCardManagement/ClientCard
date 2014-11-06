package com.ClientCardManagement.service;

import com.ClientCardManagement.model.DepartTree;

public interface DepartTreeService {

	public DepartTree getCompanys();

	public DepartTree getNoDepartNodes(DepartTree trees);
	public DepartTree getLeafNodes(DepartTree trees);
	public DepartTree getDeparts(DepartTree trees);

}