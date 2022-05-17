package com.hrms.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.lib.Global;

public class BaseClass extends Global {
    static Global G=new Global();
    @Parameters("browserName")
    @BeforeMethod
	public static void launchBrowser(@Optional("chrome") String browserName) throws InterruptedException {
		//DOMConfigurator.configure("log4j.xml");
    	switch (browserName.toLowerCase()) {
		case "chrome":
	    	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\ChromeDriver\\chromedriver.exe");
			//G.driver=new ChromeDriver();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
	    	System.setProperty("webdriver.firefox.driver", "E:\\Selenium\\ChromeDriver\\chromedriver.exe");
			//G.driver=new ChromeDriver();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		
		default:
			System.err.println("Browser Name is Invalid");
			break;
		}
    	//System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\ChromeDriver\\chromedriver.exe");
		//G.driver=new ChromeDriver();
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//extentReport("E:\\Selenium\\Selenium IDE\\POM FrameWork\\Reports\\extent.html");
		
	}
	 public static void openAppli() throws InterruptedException {
			driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
			test.info("Application Open");
			Thread.sleep(3000);
			Reporter.log("Application Open");
		    Log.info("Application Open");
	 }
	 @AfterMethod
	 public static void closeAppli() throws InterruptedException {
		//DOMConfigurator.configure("log4j.xml");
		driver.close();
		test.info("Application Close");
		Log.info("Appli Close");
		//test.pass("Test Case Pass");
		extentReportFlush();
		
	}
	public static void extentReport(String path) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(path);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Report");
		extent.attachReporter(spark);

	}
	public static void extentReportFlush() {
		extent.flush();
	}
	public static String captureScr(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("E:\\Selenium\\Selenium IDE\\POM FrameWork\\Screenshot\\"+System.currentTimeMillis()+".png");
		String absolutePathtrg = trg.getAbsolutePath();
		//FileUtils.copyFile(src, trg);
		FileHandler.copy(src, trg);
		return absolutePathtrg;
		
	}
	@DataProvider(name = "loginTestData")
	public Object[][] dataProvider() {
		Object[][] data = new Object[1][2];
		data[0][0] = "admin";
		data[0][1] = "admin";
		//data[1][0] = "Admin";
		//data[1][1] = "Admin";
		return data;
		
	}

}
