package com.hrms.pages;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.hrms.lib.Global;
import com.hrms.utility.BaseClass;
import com.hrms.utility.Log;

public class LoginPage extends Global {
	/*static By txt_username=By.name("txtUserName");
	static By txt_password=By.name("txtPassword");
	static By bt_login=By.name("Submit");
	LoginPage(WebDriver driver){
		Global.driver = driver;
	}*/
	@FindBy(how = How.NAME,using = "txtUserName")
	WebElement txt_username;
	@FindBy(how = How.NAME,using = "txtPassword")
	WebElement txt_password;
	@FindBy(how = How.NAME,using = "Submit")
	WebElement submit;
    public LoginPage(WebDriver driver){
		Global.driver = driver;
		PageFactory.initElements(driver, this);
    }
	//	public static void login(String un,String pw) throws InterruptedException {
	public void login(String un,String pw) throws InterruptedException, IOException {
		//DOMConfigurator.configure("log4j.xml");
		/*driver.findElement(txt_username).sendKeys(un);
		driver.findElement(txt_password).sendKeys(pw);
		driver.findElement(bt_login).click();*/
		txt_username.sendKeys(un);
		txt_password.sendKeys(pw);
		submit.click();
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management")) {
			Log.info("Login not Complited");
			Reporter.log("Login not Complited");
			test.info("Login not Complited");
		}
		else {
			Log.info("Login Complited");
			Reporter.log("Login Complited");
			test.info("Login Complited");
		}
		//Thread.sleep(3000);

		//SoftAssert sa = new SoftAssert();
		//sa.assertEquals("OrangeHRM", "OrangeHRM");
		//Assert.assertEquals("OrangeHRM", "OrangeHRM");
		if(driver.getTitle().equals("OrangeHRM")) {

			Log.info("After Login Title Match");
			Reporter.log("After Login Title Match");
			test.info("After Login Title Match");
		}
		else {
			Log.info("After Login Title not Match");
			Reporter.log("After Login Title not Match");
			test.info("After Login Title not Match");
		}
	}

}
