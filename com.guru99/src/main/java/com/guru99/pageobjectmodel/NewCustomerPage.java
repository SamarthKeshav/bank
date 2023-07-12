package com.guru99.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.guru99.generic.BaseClass;

public class NewCustomerPage extends BaseClass {
	@FindBy(xpath="//label[@id='message']/../input")
	WebElement customernametxtbox;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement radiomalebtn;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement radiofemalebtn;

	@FindBy(xpath="//textarea")
	WebElement addressbox;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement citytxbox;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement statetxbox;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement telephonetxbox;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailtxbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwdtxbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement sumbitbtn;
	
	@FindBy(xpath="//input[@type='reset']")
	WebElement resetbtn;
}