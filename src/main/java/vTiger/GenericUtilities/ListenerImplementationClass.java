package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to the ITestListener Interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---> test execution started");
		
	    test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" -> success");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" -> Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		String screenshotname = methodName+"-"+jUtil.getSystemDateInFormat();
		                        
		try {
			String path = wUtil.taketheScreenShot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" -> skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		// configure the report
		System.out.println("Execution Started");
		
		//Create object of Extent Spark reporter class                             Report-1 Dec 2022 17-05-32.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		//Attach the htmlreport to Extent Report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Author", "Chaitra");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution Finished");
		
		//Flush the report - consolidate the status of every test script and generate the report
		report.flush();
	}
	
}
