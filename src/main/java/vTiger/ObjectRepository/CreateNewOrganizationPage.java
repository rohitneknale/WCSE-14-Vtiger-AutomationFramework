package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	/**
	 * This method will create organization with mandatory details
	 * @param orgName
	 */
	public void createNewOrganization(String orgName)
	{
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create new organization with industry drop down
	 * @param OrgName
	 * @param industryType
	 */
	public void createNewOrganization(String OrgName, String industryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryDropDown, industryType);
		saveBtn.click();
	}
	
}
