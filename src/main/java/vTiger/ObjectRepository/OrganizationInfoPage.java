package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	//Business Logic
	/**
	 * This method will return the header text of organization
	 * @return
	 */
	public String getOrganizationHeaderText()
	{
		 return OrgHeaderText.getText();
	}
}
