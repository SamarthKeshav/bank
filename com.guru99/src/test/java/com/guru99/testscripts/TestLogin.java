package com.guru99.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.generic.BaseClass;
import com.guru99.generic.Lib;
import com.guru99.pageobjectmodel.HomePage;
import com.guru99.pageobjectmodel.LoginPage;




public class TestLogin extends BaseClass{
	@Test(dataProvider="login")
	public void testUser(String un,String pwd,String condition) throws IOException {
	System.out.println(un+" ------- "+pwd);
	LoginPage lp=new LoginPage(driver);
	HomePage hp= new HomePage(driver);
	lp.setLogin(un,pwd);
	if(condition.equals("valid"))
	{
		boolean c1 = hp.getManagerID().isDisplayed();
		assertTrue(c1);
		WebElement ele=hp.getManagerID();
		File scr=ele.getScreenshotAs(OutputType.FILE);
		File trg= new File(".//SS//ONE.png");
		FileUtils.copyFile(scr,trg);
	}
	if(condition.equals("invalid"))
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		{
			Alert alert= driver.switchTo().alert();
			 String text = alert.getText();
			 alert.accept();
			 assertEquals(text,"User or Password is not valid");	
		}
	}
	}
	@DataProvider(name="login")
	public Object [][] getLoginData() throws EncryptedDocumentException, IOException{
		Lib l=new Lib();
		return l.toReadMultipleData("Sheet1");
	}
}
