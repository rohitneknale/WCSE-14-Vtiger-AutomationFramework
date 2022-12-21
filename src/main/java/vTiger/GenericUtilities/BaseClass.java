package vTiger.GenericUtilities;
/**
 * This class consists of Basic Configuration annotations.
 * @author Chaitra M
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public static WebDriver sdriver = null;
	
	public WebDriver driver = null;
	
	@BeforeSuite(groups = {"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("==========Database Connection successfull========");
	}

	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","ReggressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("=========="+BROWSER+"---- Browser is launched =======");
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("=========="+BROWSER+"---- Browser is launched =======");
		}
		else
		{
			System.out.println("======== Invalid Browser details ===========");
		}
		
		sdriver=driver;
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
			
	}
	
	@BeforeMethod(groups = {"SmokeSuite","ReggressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("========== Login To App is Successfull =======");
	}
	
	@AfterMethod(groups = {"SmokeSuite","ReggressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("========== Logout Of App is Successfull =======");
		
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","ReggressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("========== Browser is closed =======");
	}
	
	@AfterSuite(groups = {"SmokeSuite","ReggressionSuite"})
	public void asConfig()
	{
		System.out.println("========== Database is closed =======");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
