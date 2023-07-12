package com.guru99.testscripts;


import org.testng.annotations.Test;

import com.guru99.generic.BaseClass;
import com.guru99.pageobjectmodel.HomePage;


public class TestHome extends BaseClass{
	@Test(priority=2)				//retryAnalyzer=IRetryAnalyzerImp.class
	public void title() {
		HomePage hp =new HomePage(driver);
		hp.testTitle();
	}
	
	@Test(priority=1)
	public void  UserAfterLogin() throws Throwable {
		HomePage hp =new HomePage(driver);
		hp.verifyUser();
	}
}
