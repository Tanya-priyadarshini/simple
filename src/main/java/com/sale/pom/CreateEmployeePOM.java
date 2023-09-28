package com.sale.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sales.genericUtils.BaseClass;
import com.sales.genericUtils.ExcelUtility;
import com.sales.genericUtils.FileUtility;
import com.sales.genericUtils.JavaUtility;
import com.sales.genericUtils.WebDriverUtility;

public class CreateEmployeePOM extends BaseClass {

	@Test(groups = {"smoke","regression"})
	public void createEmployeePOM() throws EncryptedDocumentException, IOException {
		
		
		elib.getRowCount("Employee");
	    wlib.acceptAlertPopup(driver, "Prince Ly Welcome!");
		HomePage hp=new HomePage(driver);
		hp.getEmployeePage();
		EmployeePage emp=new EmployeePage(driver);
		emp.getEmployeeIcon();
		Assert.assertEquals(false, false);
	    emp.createEmployee(elib.getMultipleDataFromExcelSheet("Employee", 0, 1, driver), driver);
		emp.dropDown(wlib, "Male", "Manager", "Abra", "Luba");
		emp.createDte("01", "09", "1999");
		emp.clickSubmit();
		
		

	}

}
