package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organizations", 1, 2);
		System.out.println(data);
		int row = eUtil.getRowCount("Organizations");
		System.out.println(row);
		
		eUtil.writeDataIntoExcel("Organizations", 1, 6, "Chaitra");
		System.out.println("data added");
		
		JavaUtility jUtil = new JavaUtility();
		int num = jUtil.getRandomNumber();
		System.out.println(num);
		
		String d = jUtil.getSystemDate();
		System.out.println(d);
		
		System.out.println(jUtil.getSystemDateInFormat());

	}

}
