package com.sales.genericUtils;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.sale.pom.HomePage;
import com.sale.pom.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
@BeforeSuite(alwaysRun = true)
public void configuBs() throws Throwable {
	dlib.connectToDB();
	System.out.println("connect to db");
}
//@Parameters("BROWSER")
@BeforeClass(alwaysRun = true)
public void configBC() throws Throwable {
	String BROWSER = flib.getPropertyKeyValue("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		 driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	sdriver=driver;
	wlib.maximizeTheBrowser(driver);
	wlib.implicitWait(driver, 10);	
}
@BeforeMethod(alwaysRun = true)
public void configBM() throws Throwable {
	String URL = flib.getPropertyKeyValue("url");
	String USERNAME = flib.getPropertyKeyValue("username");
	String PASSWORD = flib.getPropertyKeyValue("password");
	driver.get(URL);

	LoginPage lp=new LoginPage(driver);
	lp.getLoginPage(USERNAME, PASSWORD);
	System.out.println("login to the application");
	
}
@AfterMethod(alwaysRun = true)
public void configAM() {
	HomePage hp=new HomePage(driver);
	hp.logout(wlib, driver);
	System.out.println("logout from application");
}
@AfterClass(alwaysRun = true)
public void configAC() {
	driver.quit();
	System.out.println("close the browser");
}
@AfterSuite(alwaysRun = true)
public void configAS() throws Throwable {
	dlib.closeDB();
	System.out.println("disconnect the db");
}


}
