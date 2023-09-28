package com.sale.pom;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sales.genericUtils.BaseClass;
import com.sales.genericUtils.ExcelUtility;
import com.sales.genericUtils.FileUtility;
import com.sales.genericUtils.JavaUtility;
import com.sales.genericUtils.WebDriverUtility;


public class CreateCustomerPOM extends BaseClass{
@Test
	public void createCustomerPOM() throws EncryptedDocumentException, IOException {
	
		
	   elib.getRowCount("Createcustomer");
		wlib.acceptAlertPopup(driver, "Prince Ly Welcome!");
		HomePage hp=new HomePage(driver);
		hp.getPosPage();
		CreateCustomerpage cp=new CreateCustomerpage(driver);
		cp.keyboardOrder();
		cp.createCustomer(elib.getMultipleDataFromExcelSheet("Createcustomer", 0, 1, driver), driver);
		cp.subBtn();
		Assert.assertEquals("a", "a");
		OderingMultipleProductPage opp=new OderingMultipleProductPage(driver);
		opp.getPayment(wlib, "316", "250");
		wlib.acceptAlertPopup(driver, "Success.");
		driver.findElement(By.xpath("//div[text()='Sales and Inventory System']")).click();
		
	


	}

}
