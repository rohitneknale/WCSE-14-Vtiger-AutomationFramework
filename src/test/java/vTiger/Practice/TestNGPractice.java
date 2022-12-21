package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void createCustomerTest()
	{	
		System.out.println("Create customer");	
	}
	
	@Ignore
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	
	@Test(enabled = false)
	public void deleteCustomerTest()
	{
		System.out.println("Delete Customer");
	}
}
