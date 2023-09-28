package com.sale.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	@FindBy(xpath="//table[@id='dataTable']/tbody/tr[2]/td[7]")
	private WebElement prodname;
	@FindBy(xpath="//table[@class='table table-bordered dataTable no-footer']/tbody/tr[1]/td[8]")
	private WebElement editbtn;
	@FindBy(xpath="//div[@class='col-sm-9']/descendant::input[@name='qty']")
	private WebElement qtybtn;
	@FindBy(xpath="//div[@class='col-sm-9']/descendant::input[@name='oh']")
	private WebElement ohbtn;
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updatebtn;
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getQtybtn() {
		return qtybtn;
	}

	public WebElement getOhbtn() {
		return ohbtn;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}
	
	public void editInventory() {
		prodname.click();
		editbtn.click();
		qtybtn.clear();
		ohbtn.clear();	
	}
	public void editText(HashMap<String, String>map,WebDriver driver) {
		for(Entry<String, String> e:map.entrySet()) {
			  
			  driver.findElement(By.xpath(e.getKey())).sendKeys(e.getValue());
		 
	  }}
		public void btnUpdate() {
			updatebtn.click();
		}
	}


