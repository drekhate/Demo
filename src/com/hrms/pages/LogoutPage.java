package com.hrms.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hrms.lib.Global;
import com.hrms.utility.BaseClass;
import com.hrms.utility.Log;

public class LogoutPage extends Global{
	//static By logout_btn = By.linkText("Logout");
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	WebElement logout_btn;
	public LogoutPage(WebDriver driver){
		Global.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public  void logout() throws IOException {
		try {
			logout_btn.click();
			test.info("Logout Complited");
			Log.info("Logout Complited");
			Reporter.log("Logout Complited");
		} catch(Exception e) {
			test.addScreenCaptureFromPath(BaseClass.captureScr(driver));
			test.fail(e.getMessage());
			test.info("Logout not Complited");
			Log.info("Logout not Complited");
			Reporter.log("Logout not Complited");
			
		}
		
	}

}
