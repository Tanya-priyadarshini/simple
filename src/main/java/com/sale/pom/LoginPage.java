package com.sale.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement usenametbx;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pwdtbx;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement logintbx;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getUsenametbx() {
		return usenametbx;
	}
	public WebElement getPwdtbx() {
		return pwdtbx;
	}
	public WebElement getLogintbx() {
		return logintbx;
	}
	
	
	public void getLoginPage(String username,String password) {
		usenametbx.sendKeys(username);
		pwdtbx.sendKeys(password);
		logintbx.click();
	}

}
