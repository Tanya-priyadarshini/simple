package com.sale.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.ExcelUtility;
import com.sales.genericUtils.WebDriverUtility;

public class EmployeePage extends WebDriverUtility {
	
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement empicon;
	@FindBy(xpath="(//input[@placeholder='First Name'])[3]")
	private WebElement firstnametbx;
	@FindBy(xpath="(//input[@placeholder='Last Name'])[3]")
	private WebElement lastnametbx;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailtbx;
	@FindBy(xpath="(//input[@name='phonenumber'])[3]")
	private WebElement phntbx;
	@FindBy(xpath="//select[@name='gender']")
	private WebElement gdrdpdwn;
	@FindBy(xpath="//select[@name='jobs']")
	private WebElement jobdpdwn;
	@FindBy(id="FromDate")
	private WebElement date;
	@FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::select[@name='province']")
	private WebElement provincesdpdwn;
	@FindBy(xpath="(//select[@class='form-control'])[4]")
	private WebElement citydpdwn;
	@FindBy(xpath="(//button[@class='btn btn-success'])[3]")
	private WebElement submitbtn;
	
	
	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getEmpicon() {
		return empicon;
	}


	public WebElement getFirstnametbx() {
		return firstnametbx;
	}


	public WebElement getLastnametbx() {
		return lastnametbx;
	}


	public WebElement getEmailtbx() {
		return emailtbx;
	}


	public WebElement getPhntbx() {
		return phntbx;
	}


	public WebElement getGdrdpdwn() {
		return gdrdpdwn;
	}


	public WebElement getJobdpdwn() {
		return jobdpdwn;
	}


	public WebElement getDate() {
		return date;
	}


	public WebElement getProvincesdpdwn() {
		return provincesdpdwn;
	}


	public WebElement getCitydpdwn() {
		return citydpdwn;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void getEmployeeIcon() {
		empicon.click();
	}
	public void createEmployee(HashMap<String, String>map,WebDriver driver) {
		
		for(Entry<String, String> e:map.entrySet()) {
			  
			  driver.findElement(By.xpath(e.getKey())).sendKeys(e.getValue());
		 
	  }
	 
  }
		
	public void createDte(String datee,String mon,String year) {
		date.click();
		date.sendKeys(datee);
		date.sendKeys(mon);
		date.sendKeys(year);
	}
	
	public void dropDown(WebDriverUtility wlib,String gndvalue,String jobvalue,String provivalue,String cityvalue) {
		wlib.selectDropdown(gndvalue, gdrdpdwn);
		wlib.selectDropdown(jobvalue, jobdpdwn);
		wlib.selectDropdown(provivalue, provincesdpdwn);
		wlib.selectDropdown(cityvalue, citydpdwn);
	}
	public void clickSubmit() {
		submitbtn.click();
		
		
	}
}


