package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is the implementation class for IretryAnalyser interface of TestNG 
 * @author Chaitra M
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	/**
	 * This method will retry the failed test scripts for retryCount
	 */
	int count = 0;
	int retryCount = 3; // manually we should check 
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
