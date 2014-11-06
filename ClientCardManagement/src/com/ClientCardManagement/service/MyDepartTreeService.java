package com.ClientCardManagement.service;

import com.ClientCardManagement.model.DepartTree;

public interface MyDepartTreeService {

	public DepartTree getCompanys();

	public DepartTree getDeparts(DepartTree trees);

	public DepartTree getNoDepartNodes(DepartTree trees);

	public DepartTree getLeafNodes(DepartTree trees);

}