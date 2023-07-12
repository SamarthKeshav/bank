package com.guru99.generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.guru99.pageobjectmodel.HomePage;
import com.guru99.pageobjectmodel.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	 static
	    {
	    	WebDriverManager.chromedriver().setup();
	    	WebDriverManager.firefoxdriver().setup();
	    	WebDriverManager.edgedriver().setup();
	    	
	    }
	   
	      
	    	@Parameters("browser")
	    	@BeforeTest
	    	
	    	public static void launchApp(@Optional("firefox")String browser) throws Throwable {
	    		
	    			if (browser.equalsIgnoreCase("chrome")) {
	    				ChromeOptions options=new ChromeOptions();
	    		    	options.addArguments("--disable-popup-blocking");
	    	            driver=new ChromeDriver(options);
	    	        } else if (browser.equalsIgnoreCase("firefox")){
	    	        	FirefoxOptions options=new FirefoxOptions();
	    		    	options.addArguments("--disable-popup-blocking");
	    	            driver=new FirefoxDriver(options);
	    	        } else if (browser.equalsIgnoreCase("edge")){
	    	            driver=new EdgeDriver();
	    	        }
	    	}
	    	
	    	@BeforeMethod
	    	public void openSite() throws Throwable{
	    	     //Library class of generic package
	    		Lib l= new Lib();
	    		String url= l.getPropertyData("url");
	    	    driver.get(url);
	    	    driver.manage().window().maximize();
	    	    driver.manage().timeouts().implicitlyWait(driver, TimeUnit.SECONDS(10));
	    	    LoginPage lp = new LoginPage(driver);
		    	 lp.setLogin("mngr513204","hydynUr");
	    	}
	    	   
	    	    //create an object and set here
	         
		    @AfterMethod
	    	public void Logout() {
		    	HomePage hp = new HomePage(driver);
		    		hp.getLogOffBtn().click();
		    		driver.switchTo().alert().accept();
		    	} 
		    
		    @AfterTest
	    	public void closeServer(){
	    	    driver.quit();
	    	}
}
