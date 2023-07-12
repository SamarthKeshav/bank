package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	@FindBy(xpath=("//input[@name='uid']"))
	WebElement usernametextbox;

	@FindBy(xpath=("//input[@name='password']"))
	WebElement passwordtextbox;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void setLogin(String un ,String pwd)
	{
		usernametextbox.sendKeys(un);
		passwordtextbox.sendKeys(pwd);
		loginBtn.click();
	}
	
}

