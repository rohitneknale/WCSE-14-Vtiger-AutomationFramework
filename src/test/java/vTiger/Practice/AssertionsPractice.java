package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void assertPractice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		sa.assertEquals(false, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		sa.assertTrue(false);
		System.out.println("Step 6");
		sa.assertAll();
	}

}
