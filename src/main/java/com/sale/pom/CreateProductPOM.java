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

public class CreateProductPOM extends BaseClass {

	@Test(groups = "regression")
	public void createProductPOM() throws EncryptedDocumentException, IOException {
		elib.getRowCount("Product");
		wlib.acceptAlertPopup(driver, "Prince Ly Welcome!");
		HomePage hp=new HomePage(driver);
		hp.getProductPage();
		ProductPage pp=new ProductPage(driver);
		pp.productIcon();
		pp.createProduct(elib.getMultipleDataFromExcelSheet("Product", 0, 1, driver), driver);
		pp.forDropDown(wlib, "CPU", " Intel corportaion_654");
		pp.dateProd("05", "08", "2000");
		pp.submitBtn();
		
	}

}
