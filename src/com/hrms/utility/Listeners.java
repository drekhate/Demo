package com.hrms.utility;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Success");
		
	}

}
