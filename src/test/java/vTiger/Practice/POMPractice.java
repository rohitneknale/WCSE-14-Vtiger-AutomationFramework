package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.LoginPage;

public class POMPractice {
	
	public static void main(String[] args) {
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("manager");
//		lp.getSubmitBtn().click();
		
		lp.loginToApp("admin", "manager");
		
		
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("manager");
//		driver.findElement(By.id("submitButton")).click();
		
//		//Click on Organizations Link
//		driver.findElement(By.linkText("Organizations")).click();
//		
//		//click on create organization lookup image
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		
//		//Create new organization with mandatory information and save
//		driver.findElement(By.name("accountname")).sendKeys("Qspiders12");
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	}

}
