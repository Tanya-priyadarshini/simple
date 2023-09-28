package com.sale.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.WebDriverUtility;

public class ProductPage {
@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary']/descendant::i[@class='fas fa-fw fa-plus']")
private WebElement prodicon;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='prodcode']")
private WebElement pdcod;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='name']")
private WebElement nametbx;
@FindBy(xpath="//div[@class='form-group']/descendant::textarea[@name='description']")
private WebElement desctbx;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='quantity']")
private WebElement qnttbx;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='onhand']")
private WebElement ohtbx;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='price']")
private WebElement pricetbx;
@FindBy(xpath="//select[@name='category']")
private WebElement catdpdwn;
@FindBy(xpath="//select[@name='supplier']")
private WebElement supdpdwn;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='datestock']")
private WebElement datetbx;
@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::button[@type='submit']")
private WebElement submitbtn;

public ProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



public WebElement getProdicon() {
	return prodicon;
}

public WebElement getPdcod() {
	return pdcod;
}

public WebElement getNametbx() {
	return nametbx;
}

public WebElement getDesctbx() {
	return desctbx;
}

public WebElement getQnttbx() {
	return qnttbx;
}

public WebElement getOhtbx() {
	return ohtbx;
}

public WebElement getPricetbx() {
	return pricetbx;
}

public WebElement getCatdpdwn() {
	return catdpdwn;
}

public WebElement getSupdpdwn() {
	return supdpdwn;
}

public WebElement getDatetbx() {
	return datetbx;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}

public void productIcon() {
	prodicon.click();
}
public void createProduct(HashMap<String, String>map,WebDriver driver) {
	for(Entry<String, String> e:map.entrySet()) {
		  
		  driver.findElement(By.xpath(e.getKey())).sendKeys(e.getValue());
	 
}
}
public void forDropDown(WebDriverUtility wlib,String catvalue,String supvalue) {
	wlib.selectDropdown(catvalue, catdpdwn);
	wlib.selectDropdown(supvalue, supdpdwn);
}
public void dateProd(String date,String month,String yr) {
	datetbx.click();
	datetbx.sendKeys(date);
	datetbx.sendKeys(month);
	datetbx.sendKeys(yr);
}
public void submitBtn() {
	submitbtn.click();
}
}