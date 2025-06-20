package com.b2b.stuman.companyInfo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.b2b.stuman.baseTest.BaseClass;

public class CompanyDetailsTest extends BaseClass{
	@Test(groups = "smoke")
	public void addCompany()
	{
		System.out.println("New company has been added");
	}
	
	@Test(groups = "regression")
	public void updatecompanyDetails() 
	{
		System.out.println("Company details has been updated successfully");
	}
	
	@Test(groups = "regression")
	public void deleteCompany()
	{
		System.out.println("Company is deleted");
	}
}
