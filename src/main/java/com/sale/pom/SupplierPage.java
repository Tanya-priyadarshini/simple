package com.sale.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.WebDriverUtility;

public class SupplierPage extends WebDriverUtility {
@FindBy(xpath="//a[@data-target='#supplierModal']")
private WebElement supliicon;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='companyname']")
private WebElement compnametbx;
@FindBy(xpath="//select[@placeholder='Province']")
private WebElement provdpdwn;
@FindBy(xpath="//select[@name='city']")
private WebElement citydpdwn;
@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='phonenumber']")
private WebElement phntbx;
@FindBy(xpath="//button[.='Save']")
private WebElement hombtn;


public SupplierPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getSupliicon() {
	return supliicon;
}

public WebElement getCompnametbx() {
	return compnametbx;
}

public WebElement getProvdpdwn() {
	return provdpdwn;
}

public WebElement getCitydpdwn() {
	return citydpdwn;
}

public WebElement getPhntbx() {
	return phntbx;
}
public WebElement getHombtn() {
	return hombtn;
}


public void createSupplier(String value,WebDriverUtility wlib,String provvalue,String cityvalue,String phoneno) {
	supliicon.click();
	compnametbx.sendKeys(value);
	wlib.selectDropdown(provvalue, provdpdwn);
	wlib.selectDropdown(cityvalue, citydpdwn);
	phntbx.sendKeys(phoneno);
	hombtn.click();
	
}
}
