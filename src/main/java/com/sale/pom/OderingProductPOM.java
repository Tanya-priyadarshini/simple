package com.sale.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sales.genericUtils.BaseClass;
import com.sales.genericUtils.ExcelUtility;
import com.sales.genericUtils.FileUtility;
import com.sales.genericUtils.JavaUtility;
import com.sales.genericUtils.WebDriverUtility;

public class OderingProductPOM extends BaseClass{

	@Test(groups = {"smoke","regression"})
	public void oderingProductPOM() throws EncryptedDocumentException, IOException {
		elib.getRowCount("Inventory");
		wlib.acceptAlertPopup(driver, "Prince Ly Welcome!");
		HomePage hp=new HomePage(driver);
		hp.getPosPage();
		OderingMultipleProductPage op=new OderingMultipleProductPage(driver);
		op.orderMultipleProduct();
		op.getPayment(wlib, "25", "250");
		wlib.acceptAlertPopup(driver, "Success.");
		op.searchText("a z");
		
	}

}
