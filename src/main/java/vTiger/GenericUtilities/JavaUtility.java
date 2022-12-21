package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * this class consists of java specific methods
 * @author Chaitra M
 *
 */
public class JavaUtility {

	/**
	 * This method will generate random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}
	
	/**
	 * This method will generate the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	/**
	 * This method will generate the current system date in specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormat = date+" "+month+" "+year+" "+time;
		return dateInFormat;
		
	}
	
}
