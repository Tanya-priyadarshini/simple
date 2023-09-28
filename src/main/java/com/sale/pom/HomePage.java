package com.sale.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.genericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	@FindBy(xpath="//span[text()='Employee']")
	private WebElement emptab;
	@FindBy(xpath="//li[@class='nav-item']/descendant::span[text()='Product']")
	private WebElement prodtab;
	@FindBy(xpath="//li[@class='nav-item']/descendant::span[text()='Inventory']")
	private WebElement inventorytab;
	@FindBy(xpath="//span[.='Supplier']")
	private WebElement suplitab;
	@FindBy(xpath="//span[.='POS']")
	private WebElement posbtn;
	@FindBy(xpath="//a[@id='userDropdown']")
	private WebElement logoutbun;
	@FindBy(xpath="//a[@class='dropdown-item']/descendant::i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement logouticon;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	

	public WebElement getEmptab() {
		return emptab;
	}
	public WebElement getProdtab() {
		return prodtab;
	}
	public WebElement getInventorytab() {
		return inventorytab;
	}

	public WebElement getSuplitab() {
		return suplitab;
	}
	public WebElement getPosbtn() {
		return posbtn;
	}

	public WebElement getLogoutbun() {
		return logoutbun;
	}

	public WebElement getLogouticon() {
		return logouticon;
	}

	public WebElement getLogout() {
		return logout;
	}

	
	
	public void getEmployeePage() {
		emptab.click();
		}
	public void getProductPage() {
		prodtab.click();
	}
	public void getInventoryPage() {
		inventorytab.click();
	}
	public void getSupliPage() {
		suplitab.click();
	}
    public void getPosPage() {
    	posbtn.click();
    }
    
    public void logout(WebDriverUtility wlib,WebDriver driver) {
    	getLogoutbun().click();
    	wlib.mouseHover(driver, logouticon);
    	getLogout().click();
    	driver.close();
    }
}
