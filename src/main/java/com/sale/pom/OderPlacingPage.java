package com.sale.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OderPlacingPage {
@FindBy(xpath="//a[text()='Keyboard']")
private WebElement keyboardbtn;
@FindBy(xpath="//h6[text()='Newmen E120']/following-sibling::input[@type='submit']")
private WebElement submitbtn;
@FindBy(xpath="//select[@name='customer']")
private WebElement customerdpdwn;

public OderPlacingPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getKeyboardbtn() {
	return keyboardbtn;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}

public WebElement getCustomerdpdwn() {
	return customerdpdwn;
}
  public void keyboardOrder() {
	  keyboardbtn.click();
	  submitbtn.click();
  }




}
