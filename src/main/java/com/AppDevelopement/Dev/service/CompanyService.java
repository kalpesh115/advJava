package com.AppDevelopement.Dev.service;

import com.AppDevelopement.Dev.bean.CompanyRequest;

public interface CompanyService {

	String saveCompany(CompanyRequest request);

	String getAllComapany();



	String deleteCompany(int id);

	String getCompanyId(int id);


	String getCompanyByName(String companyName);

	
	

}
