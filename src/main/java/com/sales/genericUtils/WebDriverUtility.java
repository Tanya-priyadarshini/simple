package com.sales.genericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * @author TANYA
 */
public class WebDriverUtility {
	/**
	 * This method will use to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will use to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait until the element in the page gets load
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver,int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until url of the page gets load
	 * @param driver
	 * @param duration
	 * @param url
	 */
	public void explicitWait(WebDriver driver,int duration,String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * This method will wait until title of the page gets load
	 * @param driver
	 * @param duration
	 * @param title
	 */
	public void waitUntilTitlesLoad(WebDriver driver,int duration,String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method will wait until elements in the pages gets load
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,int duration,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore the NoSuchElementException and continue the execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
		}
	/**
	 * This method will use to select a dropdown element based on index
	 * @param element
	 * @param index
	 */
	public void selectDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 * This method will use to select the dropdown element based on the value
	 * @param element
	 * @param value
	 */
	public void selectDrodown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will use to select the dropdown element based on the text
	 * @param text
	 * @param element
	 */
	public void selectDropdown(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		}
	/**
	 * This method will use foe click on enter key
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is use to release the key
	 * @param driver
	 * @throws AWTException
	 */
	public void enterRelease(WebDriver driver) throws AWTException {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);	
	}
	/**
	 * This method is use to mousehover on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	/**
	 * This method is use to right click on an element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a= new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is use to drag and drop on an element
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dst);
	}
	/**
	 * This method will double click on webpage
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is use to switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is use to switch from one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
		}
	/**
	 * This method is use to switch from one frame to another using webelement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is use to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is use to accept the alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver,String expectedMsg) {
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("alert msg is verified");
		}
		else {
			System.out.println("alert msg is not verified");
		}
		alert.accept();
	}
	/**
	 *  This method is use to dismiss the alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void dismissAlertPopup(WebDriver driver,String expectedMsg) {
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("alert msg is verified");
		}
		else {
			System.out.println("alert msg is not verified");
		}
		alert.dismiss();
	}
	/**
	 * This method is use to switch from one to another based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle) {
		Set<String> wh = driver.getWindowHandles();
		for(String str:wh) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle)) {
				break;
			}
		}}
	/**
	 * This method is use to switch from one to another based on url
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchWindowBasedOnUrl(WebDriver driver,String expectedUrl) {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while(it.hasNext())
		{
			String str = it.next();
			driver.switchTo().window(str);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl)) {
				break;
			}
		}}
	/**
	 * This method is use to take screenshot whenever the testscript getting failed
	 * @param driver
	 * @param screenshotname
	 * @return
	 */
	public static String takeScreenshot(WebDriver driver,String screenshotname) {
       TakesScreenshot t=(TakesScreenshot)driver;
       File src = t.getScreenshotAs(OutputType.FILE);
      File dst = new File("./screenshots/"+screenshotname+".png");
      try {
    	  Files.copy(src, dst);}
      catch(IOException e) {
    	e.printStackTrace();  
      }
	return screenshotname;
	}
	/**
	 * This method is used to scrollTo particular element
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		}
	/**
	 * This method will perform random scroll
	 * @param driver
	 * @param element
	 */
	public void scrollBarAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)", element);
		}
	}


