package com.sales.genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{
	int count=0;
	int upper=3;
	@Override
	public boolean retry(ITestResult result) {

		if(count<upper) {
			count++;
			return true;
		}
		return false;
	}

}
