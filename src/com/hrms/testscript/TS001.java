package com.hrms.testscript;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.hrms.lib.Global;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LogoutPage;
import com.hrms.utility.BaseClass;
import com.hrms.utility.Log;

public class TS001 extends BaseClass {
/*	@Parameters({"un" , "pw"})
	@Test()  
	public void login_logout(String un , String pw) throws InterruptedException, IOException {
		DOMConfigurator.configure("log4j.xml");
		//BaseClass.launchBrowser();
		BaseClass.extentReport("E:\\Selenium\\Selenium IDE\\POM FrameWork\\Reports\\extent 2.html");
		test = extent.createTest("login_logout");
		test.info("Browser Launch");
		Log.info("Browser Launch");
		Reporter.log("Browser Launch");
		BaseClass.openAppli();
		LoginPage lp = new LoginPage(Global.driver);
		LogoutPage logout = new LogoutPage(Global.driver);
		//lp.login("admin", "admin");
		lp.login(un, pw);
		logout.logout();

		//LoginPage.login("admin", "admin");
		//LogoutPage.logout();
		//BaseClass.closeAppli();
	}*/
	@Test(priority = 1, dataProvider = "loginTestData")
	public void login_logout(String username , String password) throws InterruptedException, IOException {
		DOMConfigurator.configure("log4j.xml");
		//BaseClass.launchBrowser();
		BaseClass.extentReport("E:\\Selenium\\Selenium IDE\\POM FrameWork\\Reports\\extent 1.html");
		test = extent.createTest("login_logout");
		test.info("Chrome Browser Launch");
		BaseClass.openAppli();
		LoginPage lp = new LoginPage(Global.driver);
		LogoutPage logout = new LogoutPage(Global.driver);
		//lp.login("admin", "admin");
		lp.login(username, password);
		//test.info("Appli Login Complited");
		logout.logout();

		//LoginPage.login("admin", "admin");
		//LogoutPage.logout();
		//BaseClass.closeAppli();
		
	}

}
