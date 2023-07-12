package com.guru99.pageobjectmodel;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.generic.BaseClass;



//@Listeners(com.guru99.generic.ITestListnerImp.class)

public class HomePage extends BaseClass {
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOffBtn;
	
	@FindBy(xpath="//a[text()='New Customer'])")
	WebElement newcustomerbtn;
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement deletecustomerbtn;
	
	@FindBy(xpath="//td[contains(text(),'Manger Id : mngr513204')]")
	WebElement managerID;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public WebElement getNewcustomerbtn() {
		return newcustomerbtn;
	}
	public WebElement getDeletecustomerbtn() {
		return deletecustomerbtn;
	}
	public WebElement getLogOffBtn() {
		return logOffBtn;
	}
	
	//Getters and Setters method 
	/*public  void  setManagerID(WebElement managerID) {
	this.managerID=managerID;
	}*/
	public WebElement getManagerID() {
		return managerID;
	}
	// To verify the Title of the HomePage
	public void testTitle() {
		String aTitle= driver.getTitle();
		String exTitle="Guru99 Bank Manager HomePage";
		Assert.assertEquals(aTitle, exTitle);
	}
	// To verify the managerID after Logging in
	public void  verifyUser()
	{
		HomePage hp= new HomePage(driver);
		String expectedIDOnPage="Manger Id : mngr513204";
		String actualIDOnPage =hp.getManagerID().getText();

		Assert.assertEquals(actualIDOnPage, expectedIDOnPage);
	}
	
	public void newCustomer() {
		newcustomerbtn.click();
	}
}

