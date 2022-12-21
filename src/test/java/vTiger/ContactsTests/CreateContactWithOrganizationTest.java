package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	
      @Test(groups = "SmokeSuite")
      public void createContactWithOrgTest() throws IOException
	  {
		//Step 1: read test Data
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
	
		//Step 5: Navigate to Organizations LInk
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("Organization is clicked",true);
		//Assert.fail();
		
		//Step 6: Click On create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Create organization look up image is clicked",true);
		
		//Step 7: Create Organization with Mandatory details and Save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("Organization is created with "+ORGNAME, true);
		
		//Step 8 Validate Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	
		
		//Step 9: Navigate to Contacts link
		hp.clickOnContactsLink();
		Reporter.log("Contacts link is clicked");
		
		//Step 10: Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Create Contacts loop up image is clicked");
		
		//Step 11: Create Contact with mandatory fields 
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("New Contact with organization is created ->"+LASTNAME, true);
		
		//Step 16: Validate for Contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
		
		
	}
      
  
    @Test(groups = "ReggressionSuite")
    public void DemoTest()
    {
    	
    	System.out.println("This is Demo");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
