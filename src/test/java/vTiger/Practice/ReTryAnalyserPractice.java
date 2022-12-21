package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ReTryAnalyserPractice {
	
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void prcaticeRetry()
	{
		
		System.out.println("Run");
		Assert.fail();
	}

	@Ignore
	@Test
	public void prcaticeRetry1()
	{
		System.out.println("Run 1");
	}
}
