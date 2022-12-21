package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Library
	/**
	 * This method will click on organizations link in home page
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on contacts link in home page
	 */
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}

	/**
	 * This method will sign out of app
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
}
