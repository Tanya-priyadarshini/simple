package com.sale.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.WebDriverUtility;

public class CreateCustomerpage  {
	@FindBy(xpath="//a[text()='Keyboard']")
	private WebElement keyboardbtn;
	@FindBy(xpath="//h6[text()='Newmen E120']/following-sibling::input[@type='submit']")
	private WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement custbtn;
	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']/descendant::input[@name='firstname']")
private WebElement fname;
@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']/descendant::input[@name='lastname']")
private WebElement lname;
@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']/descendant::input[@name='phonenumber']")
private WebElement pnno;
@FindBy(xpath="(//button[.='Save'])[2]")
private WebElement subbtn;


public CreateCustomerpage (WebDriver driver) {

	PageFactory.initElements(driver, this);
}

 public WebElement getKeyboardbtn() {
	return keyboardbtn;
}
public WebElement getSubmitbtn() {
	return submitbtn;
}
public WebElement getCustbtn() {
	return custbtn;
}
public WebElement getFname() {
	return fname;
}
public WebElement getLname() {
	return lname;
}

public WebElement getPnno() {
	return pnno;
}

public WebElement getSubbtn() {
	return subbtn;
}



public void keyboardOrder() {
	 keyboardbtn.click();
	 submitbtn.click();
	 custbtn.click();
	 
 }

public void createCustomer(HashMap<String, String>map,WebDriver driver) {
	
	for(Entry<String, String> e:map.entrySet()) {
		  
		  driver.findElement(By.xpath(e.getKey())).sendKeys(e.getValue());
	 
  }}
	public void subBtn() {
		subbtn.click();
	}
}



