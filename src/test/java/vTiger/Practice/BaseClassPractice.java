package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	
	@Test
	public void test()
	{
		System.out.println("Test 1");
	}
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before Suite");
	}

	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before Method");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before Classs");
	}
	
	
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After Method");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After suite");
	}
	@AfterClass
	public void acConfig()
	{
		System.out.println("After Class");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
