package com.guru99.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ITestListnerImp extends BaseClass implements ITestListener {
	Lib l=new Lib();
	@Override
	public void onTestStart(ITestResult result) {
		String startName = result.getName();
		Reporter.log("the "+startName+" method started to execute at "+l.getTime(),true);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testSuccess = result.getName();
		Reporter.log("the method has been successfully executed : "+testSuccess);	
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	String name = result.getName();
	String stamp = LocalDateTime.now().toString().replaceAll(":", "-");
	TakesScreenshot ts= (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest= new File("./screenShot/"+name+stamp+".png");
	
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
