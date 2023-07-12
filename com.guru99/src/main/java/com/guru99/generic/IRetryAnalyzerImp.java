package com.guru99.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImp implements IRetryAnalyzer {
	int count=0;
	int max=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}
	}

	/* you can add IRetryAnalyser in testng.xml file
	 after <suite> and before <test> tag add--
	<listeners>
	<listener class-name="com.guru99.generic.IRetryAnalyzerImp.class"></listener>
	<listener class-name="com.guru99.generic.ITestListnerImp.class"></listener>
	</listeners>
	It is used to retry failed test cases (3 times)*/

