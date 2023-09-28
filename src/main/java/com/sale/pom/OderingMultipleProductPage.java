package com.sale.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.WebDriverUtility;

public class OderingMultipleProductPage extends WebDriverUtility {
	@FindBy(xpath="//a[.='Motherboard']")
	private WebElement motherboardbtn;
	@FindBy(xpath="//h6[text()='Intel 12th gen mother board']/following-sibling::input[@value='Add']")
	private WebElement motherboardprod;
	@FindBy(xpath="//a[.='Processor']")
	private WebElement procbtn;
	@FindBy(xpath="//h6[text()='hp']/following-sibling::input[@class='btn btn-info']")
	private WebElement processorbtn;
	@FindBy(xpath="//select[@name='customer']")
	private WebElement customerdpdwn;
	@FindBy(xpath="//button[.='SUBMIT']")
	private WebElement submitbtn;
	@FindBy(xpath="//input[@placeholder='ENTER CASH']")
	private WebElement cashtbx;
	@FindBy(xpath="//button[text()='PROCEED TO PAYMENT']")
	private WebElement paymentbtn;
	@FindBy(xpath="//div[.='Sales and Inventory System']")
	private WebElement saislink;
	@FindBy(xpath="//span[.='Transaction']")
	private WebElement transactiontab;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchbtn;
	

	public OderingMultipleProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getMotherboardbtn() {
		return motherboardbtn;
	}


	public WebElement getMotherboardprod() {
		return motherboardprod;
	}


	public WebElement getProcbtn() {
		return procbtn;
	}


	public WebElement getProcessorbtn() {
		return processorbtn;
	}


	public WebElement getCustomerdpdwn() {
		return customerdpdwn;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}


	public WebElement getCashtbx() {
		return cashtbx;
	}


	public WebElement getPaymentbtn() {
		return paymentbtn;
	}


	public WebElement getSaislink() {
		return saislink;
	}


	public WebElement getTransactiontab() {
		return transactiontab;
	}


	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public void orderMultipleProduct() {
		motherboardbtn.click();
		motherboardprod.click();
		procbtn.click();
		processorbtn.click();
	}
	public void getPayment(WebDriverUtility wlib,String value,String amount) {
		wlib.selectDrodown(customerdpdwn, value);
		submitbtn.click();
		cashtbx.sendKeys(amount);
		paymentbtn.click();
		
	}
	public void searchText(String name) {
		saislink.click();
		transactiontab.click();
		searchbtn.sendKeys(name);
	}


}
